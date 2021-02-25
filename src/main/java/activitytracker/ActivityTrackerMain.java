package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain {


/*    CREATE TABLE activities (
            id BIGINT AUTO_INCREMENT,
            start_time TIMESTAMP,
            activity_desc VARCHAR(255),
    activity_type VARCHAR(255),
    PRIMARY KEY (id));
*/


    public static void main(String[] args) {

        //rácsatlakozás az adatbázisra
        MariaDbDataSource dbDataSource;
        try {
            dbDataSource = new MariaDbDataSource();
            dbDataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dbDataSource.setUser("activitytracker");
            dbDataSource.setPassword("activitytracker");
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot create database", se);
        }

        Activity activity1 = new Activity(LocalDateTime.of(2021, 02, 23, 10, 20), "Biking in Mátra", ActivityType.BIKING);
        Activity activity2 = new Activity(LocalDateTime.of(2021, 02, 23, 11, 20), "Running in Mátra", ActivityType.RUNNING);
        Activity activity3 = new Activity(LocalDateTime.of(2021, 02, 23, 12, 20), "Hiking in Mátra", ActivityType.HIKING);

        ActivityDao activityDao = new ActivityDao(dbDataSource);

        activityDao.saveActivity(activity1);
        activityDao.saveActivity(activity2);
        activityDao.saveActivity(activity3);

        System.out.println(activityDao.findActivityById(2));
        System.out.println(activityDao.listActivities());
    }
}
