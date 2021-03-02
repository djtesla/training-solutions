package activitytracker;

import activity.Track;
import ioreader.states.State;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ActivityDao {

    MariaDbDataSource dbDataSource;

    public ActivityDao(MariaDbDataSource dbDataSource) {
        this.dbDataSource = dbDataSource;
    }


    public Activity saveActivity(Activity activity) {

        try (
                Connection connection = dbDataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement("insert into activities (start_time, activity_desc, activity_type) values(?,?,?)", Statement.RETURN_GENERATED_KEYS)) {


            ps.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            ps.setString(2, activity.getDesc());
            ps.setString(3, activity.getType().name());
            ps.executeUpdate();

            Activity result = getIdAfterExecution(activity, ps);

            saveTrackPoints(activity.getTrackPoints(), result.getId());


        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
        throw new IllegalStateException("No activity");
    }


    private void saveTrackPoints(List<TrackPoint> trackPoints, long activity_id) throws SQLException {

        try (Connection connection = dbDataSource.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement ps2 = connection.prepareStatement("insert into track_points (act_time, lat, lon, activity_id) values(?,?,?,?)")) {
                for (TrackPoint trackPoint : trackPoints) {
                    if (trackPoint.getLat() < -90 || trackPoint.getLat() > 90 ||
                            trackPoint.getLon() < -180 || trackPoint.getLat() > 180
                    ) {
                        throw new IllegalArgumentException("Invalid trackpoint");
                    }
                    ps2.setDate(1, Date.valueOf(trackPoint.getTime()));
                    ps2.setDouble(2, trackPoint.getLat());
                    ps2.setDouble(3, trackPoint.getLon());
                    ps2.setLong(4, activity_id);

                    ps2.executeUpdate();
                    connection.commit();
                }
            } catch (IllegalArgumentException iae) {
                connection.rollback();
            }
        }
    }


    private Activity getIdAfterExecution(Activity activity, PreparedStatement ps) throws SQLException {
        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                long id = rs.getLong(1); //egy oszlopos táblát ad vissza
                return new Activity(id, activity.getStartTime(), activity.getDesc(), activity.getType());
            }
            throw new IllegalStateException("Cannot get key");
        }


    }

    public List<Activity> findActivityById(long id) {
        try (
                Connection connection = dbDataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement("select * from activities where id = ?")) {
            ps.setLong(1, id);
            return queryAndCreateActivityByPreparedStatement(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }

    }


    public List<Activity> listActivities() {
        try (
                Connection connection = dbDataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement("select * from activities")) {
            return queryAndCreateActivityByPreparedStatement(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }


    private List<Activity> queryAndCreateActivityByPreparedStatement(PreparedStatement ps) {
        List<Activity> activities = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                long id = rs.getLong("id");
                LocalDateTime start = rs.getTimestamp("start_time").toLocalDateTime();
                String desc = rs.getString("activity_desc");
                ActivityType type = ActivityType.valueOf(rs.getString("activity_type"));

                List<TrackPoint> trackPoints = queryTrackpointsByID(id);
                activities.add(new Activity(id, start, desc, type, trackPoints));
            }
            if (activities.size() == 0) {
                throw new IllegalArgumentException("No record exists with given id");
            }
            return activities;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }


    private List<TrackPoint> queryTrackpointsByID(long id) {
        List<TrackPoint> trackPoints = new ArrayList<>();
        try (
                Connection connection = dbDataSource.getConnection();
                PreparedStatement ps2 = connection.prepareStatement("select * from track_point where activity_id = ?")) {
            ps2.setLong(1, id);
            try (
                    ResultSet rs2 = ps2.executeQuery()) {
                while (rs2.next()) {
                    long trackId = rs2.getLong("id");
                    LocalDate time = rs2.getTimestamp("time").toLocalDateTime().toLocalDate();
                    double lat = rs2.getDouble("lat");
                    double lon = rs2.getDouble("lon");
                    trackPoints.add(new TrackPoint(trackId, time, lat, lon, id));
                }
            }
            return trackPoints;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }


    public List<Activity> listActivitiesBefore(LocalDate localDate) {
        try (
                Connection connection = dbDataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement("select * from activities where start_time < ? ")) {

            LocalDateTime actualDate = localDate.atTime(0, 0);
            ps.setTimestamp(1, Timestamp.valueOf(actualDate));
            return queryAndCreateActivityByPreparedStatement(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }


}
