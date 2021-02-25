package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    MariaDbDataSource dbDataSource;

    public ActivityDao(MariaDbDataSource dbDataSource) {
        this.dbDataSource = dbDataSource;
    }


    public void saveActivity(Activity activity) {
        try (
                Connection connection = dbDataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement("insert into activities (start_time, activity_desc, activity_type) values(?,?,?)")) {

            ps.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            ps.setString(2, activity.getDesc());
            ps.setString(3, activity.getType().name());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
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
                activities.add(new Activity(id, start, desc, type));
            }
            if (activities.size()==0) {
                throw new IllegalArgumentException("No record exists with given id");
            }
            return activities;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }




}
