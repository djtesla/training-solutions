package activitytracker;

import jdbc.EmployeesDao;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    private ActivityDao activityDao;

    @BeforeEach
    public void init () {

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

        List<TrackPoint> trackPoints1 = Arrays.asList(new TrackPoint(LocalDate.of(2021, 02, 20), 30, 20),
                new TrackPoint(LocalDate.of(2021, 02, 21), 70, 20),
                new TrackPoint(LocalDate.of(2021, 02, 22), 30, -12));

        List<TrackPoint> trackPoints2 = Arrays.asList(new TrackPoint(LocalDate.of(2021, 02, 20), 30, 20),
                new TrackPoint(LocalDate.of(2021, 02, 21), 70, 20),
                new TrackPoint(LocalDate.of(2021, 02, 22), 30, -12));

        List<TrackPoint> trackPoints3 = Arrays.asList(new TrackPoint(LocalDate.of(2021, 02, 20), 30, 20),
                new TrackPoint(LocalDate.of(2021, 02, 21), 70, 20),
                new TrackPoint(LocalDate.of(2021, 02, 22), 30, -120));

        List<TrackPoint> trackPoints4 = Arrays.asList(new TrackPoint(LocalDate.of(2021, 02, 20), 30, 20),
                new TrackPoint(LocalDate.of(2021, 02, 21), 10, -25),
                new TrackPoint(LocalDate.of(2021, 02, 22), -30, -10));


        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 02, 23, 10, 20),
                "Biking in Mátra", ActivityType.BIKING, trackPoints1));

        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 02, 24, 10, 20),
                "Hiking in Mecsek", ActivityType.HIKING,trackPoints2));

        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 02, 25, 10, 20),
                "Running in Vecsés", ActivityType.RUNNING, trackPoints3));

        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 02, 26, 10, 20),
                "Basketballing in Pécs", ActivityType.BASKETBALL,trackPoints4));
    }

    @Test
    public void testInsert() {
        //System.out.println(activityDao.findActivityById(1));
        //System.out.println(activityDao.listActivities());
    }


    @Test
    public void testGetActivitesBefore() {
        assertEquals(3,activityDao.listActivitiesBefore(LocalDate.of(2021, 02, 26)).size());
    }

    /*
    @Test
    public void findById() {
        Activity activity = activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 02, 26, 10, 20),
                "Basketballing in Pécs", ActivityType.BASKETBALL));


        assertEquals("Basketballing in Pécs", activityDao.findActivityById(activity.getId()).get(0).getDesc());
    }*/

}