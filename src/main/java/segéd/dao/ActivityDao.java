package segéd.dao;

import activitytracker2.Activity;
import activitytracker2.ActivityType;
import activitytracker2.IllegalTrackPointException;
import activitytracker2.TrackPoint;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivityDao {

    private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public Activity saveActivity(Activity activity) {
        Activity activityWithId;
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("insert into activities (start_time, activity_desc, activity_type) values(?,?,?)",
                        Statement.RETURN_GENERATED_KEYS)) {

            ps.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            ps.setString(2, activity.getDesc());
            ps.setString(3, activity.getType().name());
            ps.executeUpdate();
            long id = getId(activity, ps);
            saveTrackPoints(activity, id);
            return new Activity(id, activity.getStartTime(), activity.getDesc(), activity.getType(), activity.getTrackPoints());

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }


    private void saveTrackPoints(Activity activity, long id) {
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            try (
                    PreparedStatement ps = conn.prepareStatement("insert into track_points (act_time, lat, lon, activity_id) values(?,?,?,?)")) {
                for (TrackPoint trackPoint : activity.getTrackPoints()) {
                    if (!isValid(trackPoint)) {
                        throw new IllegalTrackPointException("Invalid trackpoint: " + trackPoint.toString() + "; transaction will be rolled back");
                    }
                    ps.setDate(1, Date.valueOf(trackPoint.getTime()));
                    ps.setDouble(2, trackPoint.getLat());
                    ps.setDouble(3, trackPoint.getLon());
                    ps.setLong(4, id);
                    ps.executeUpdate();
                }
                conn.commit();
            } catch (IllegalTrackPointException it) {
                conn.rollback();
                System.out.println(it.getMessage());
            }


        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }


    private boolean isValid(TrackPoint trackPoint) {
        return trackPoint.getLat() <= 90 && trackPoint.getLat() >= -90 &&
                trackPoint.getLon() <= 180 && trackPoint.getLon() >= -180;
    }


    private long getId(Activity activity, PreparedStatement ps) throws SQLException {
        try (
                ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                long id = rs.getLong(1);
                return id;
            } else {
                throw new IllegalStateException("Cannot find id");
            }
        }
    }


    public List<Activity> findActivityById(long id) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("select * from activities where id=?")) {
            ps.setLong(1, id);
            return getActivitiesByPreparedStatement(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }


    private List<Activity> getActivitiesByPreparedStatement(PreparedStatement ps) throws SQLException {
        List<Activity> activities = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                long id = rs.getLong(1);
                LocalDateTime startTime = rs.getTimestamp(2).toLocalDateTime();
                String desc = rs.getString(3);
                ActivityType type = ActivityType.valueOf(rs.getString(4));
                List<TrackPoint> trackPoints = findTrackPointsById(id);

                activities.add(new Activity(id, startTime, desc, type, trackPoints));
            }
            if (activities.size() == 0) {
                throw new IllegalArgumentException("No activity exists with given id");
            }
            return activities;
        }
    }

    private List<TrackPoint> findTrackPointsById(long id) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("select * from track_points where activity_id = ?")) {
            ps.setLong(1, id);

            return getTrackPointsByPreparedStatement(ps);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }


    private List<TrackPoint> getTrackPointsByPreparedStatement(PreparedStatement ps) throws SQLException {
        List<TrackPoint> trackPoints = new ArrayList<>();
        try (
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                LocalDate time = rs.getTimestamp(2).toLocalDateTime().toLocalDate();
                double lat = rs.getDouble(3);
                double lon = rs.getDouble(4);

                trackPoints.add(new TrackPoint(time, lat, lon));
            }
            if (trackPoints.size() == 0) {
                return Collections.emptyList();
            }
            return trackPoints;
        }
    }


    public List<Activity> listAllActivities() {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("select * from activities")) {

            return getActivitiesByPreparedStatement(ps);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }


}




