package activitytracker2;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    private ActivityDao activityDao;

    public static final List<TrackPoint> TRACKPOINTS_1 = Arrays.asList(new TrackPoint(LocalDate.of(2021, 2, 23), 100, -10),
            new TrackPoint(LocalDate.of(2021, 2, 23), -10, 200),
            new TrackPoint(LocalDate.of(2021, 2, 23), -550, 50));

    public static final List<TrackPoint> TRACKPOINTS_2 = Arrays.asList(new TrackPoint(LocalDate.of(2021, 2, 23), 20, -20),
            new TrackPoint(LocalDate.of(2021, 2, 23), 10, 100),
            new TrackPoint(LocalDate.of(2021, 2, 23), 50, 50));

    public static final List<TrackPoint> TRACKPOINTS_3 = Arrays.asList(new TrackPoint(LocalDate.of(2021, 2, 23), 30, -30),
            new TrackPoint(LocalDate.of(2021, 2, 23), 100, 10),
            new TrackPoint(LocalDate.of(2021, 2, 23), 50, 50));

    public static final List<TrackPoint> TRACKPOINTS_4 = Arrays.asList(new TrackPoint(LocalDate.of(2021, 2, 23), 10, -10),
            new TrackPoint(LocalDate.of(2021, 2, 23), 90, 15),
            new TrackPoint(LocalDate.of(2021, 2, 23), -190, 0));


    public static final Activity ACTIVITY_1 = new Activity(LocalDateTime.of(2021, 02, 23, 10, 00),
            "Basketballing in Mátra", ActivityType.BASKETBALL, TRACKPOINTS_1);

    public static final Activity ACTIVITY_2 = new Activity(LocalDateTime.of(2021, 02, 24, 11, 00),
            "Running in Mátra", ActivityType.RUNNING, TRACKPOINTS_2);

    public static final Activity ACTIVITY_3 = new Activity(LocalDateTime.of(2021, 02, 25, 12, 00),
            "Hiking in Mátra", ActivityType.HIKING, TRACKPOINTS_3);

    public static final Activity ACTIVITY_4 = new Activity(LocalDateTime.of(2021, 02, 26, 12, 00),
            "Biking in Mátra", ActivityType.BIKING, TRACKPOINTS_4);

    @BeforeEach
    public void init() {


        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot create database", se);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        activityDao = new ActivityDao(dataSource);

        activityDao.saveActivity(ACTIVITY_1);
        activityDao.saveActivity(ACTIVITY_2);
        activityDao.saveActivity(ACTIVITY_3);
        activityDao.saveActivity(ACTIVITY_4);



    }


    @Test
    public void saveActivityTest() {
        //assertEquals(4, activityDao.listAllActivities().size());
        System.out.println(activityDao.listAllActivities());
    }


    @Test
    public void findActivityByIdTest() {
        System.out.println(activityDao.findActivityById(3));
    }


}