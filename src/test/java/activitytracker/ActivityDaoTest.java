package activitytracker;

import jdbc.EmployeesDao;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;

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
    }

    @Test
    public void testInsert() {
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 02, 23, 10, 20),
                "Biking in Mátra", ActivityType.BIKING));

        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 02, 23, 10, 20),
                "Hiking in Mátra", ActivityType.HIKING));

        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 02, 23, 10, 20),
                "Running in Mátra", ActivityType.RUNNING));


        System.out.println(activityDao.findActivityById(1));

        System.out.println(activityDao.listActivities());
    }

}