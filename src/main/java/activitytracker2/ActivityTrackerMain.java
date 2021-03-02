package activitytracker2;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ActivityTrackerMain {


    public static void main(String[] args) {

        Activity activity1 = new Activity(LocalDateTime.of(2021, 02, 23, 10, 20),
                "Basketballing in Mátra", ActivityType.BASKETBALL, null);

        Activity activity2 = new Activity(LocalDateTime.of(2021, 02, 24, 11, 20),
                "Running in Mátra", ActivityType.RUNNING, null);

        Activity activity3 = new Activity(LocalDateTime.of(2021, 02, 25, 12, 20),
                "Hiking in Mátra", ActivityType.HIKING, null);

        Activity activity4 = new Activity(LocalDateTime.of(2021, 02, 26, 12, 20),
                "Biking in Mátra", ActivityType.BIKING, null);

        MariaDbDataSource dbDataSource;
        try {
            dbDataSource = new MariaDbDataSource();
            dbDataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dbDataSource.setUser("activitytracker");
            dbDataSource.setPassword("activitytracker");
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot create database", se);
        }

        ActivityTrackerMain atm = new ActivityTrackerMain();
       /* atm.saveActivity(activity1, dbDataSource);
        atm.saveActivity(activity2, dbDataSource);
        atm.saveActivity(activity3, dbDataSource);*/


        //System.out.println(atm.findActivityById(2, dbDataSource));
        System.out.println(atm.listAllActivities( dbDataSource));
    }


    public void saveActivity(Activity activity, MariaDbDataSource dbDataSource) {
        try (
                Connection conn = dbDataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("insert into activities (start_time, activity_desc, activity_type) values(?,?,?)")) {

            ps.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            ps.setString(2, activity.getDesc());
            ps.setString(3, activity.getType().name());

            ps.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }


    public List<Activity> findActivityById(long id, MariaDbDataSource dbDataSource) {
        try (
                Connection conn = dbDataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("select * from activities where id=?")) {
            ps.setLong(1, id);
            return getActivities(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }



    private List<Activity> getActivities(PreparedStatement ps) throws SQLException {
        List<Activity> activities = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                long id = rs.getLong(1);
                LocalDateTime startTime = rs.getTimestamp(2).toLocalDateTime();
                String desc = rs.getString(3);
                ActivityType type = ActivityType.valueOf(rs.getString(4));
                activities.add(new Activity(id, startTime, desc, type, null));
            }
            if (activities.size() == 0) {
                throw new IllegalArgumentException("No activity exists with given id");
            }
            return activities;
        }
    }





    public List<Activity> listAllActivities(MariaDbDataSource dbDataSource) {
        try (
        Connection conn = dbDataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from activities");
        ResultSet rs = ps.executeQuery()) {
            return getActivities(ps);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }



}


