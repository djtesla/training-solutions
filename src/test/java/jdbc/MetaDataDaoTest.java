package jdbc;

import activitytracker.ActivityDao;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MetaDataDaoTest {

    MetaDataDao metaDataDao;


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

        metaDataDao = new MetaDataDao(dataSource);

    }

    @Test
    public void testTableNames() {
        List<String> names = metaDataDao.getTableNames();
        System.out.println(names);
        assertEquals(true, names.contains("cities"));




    }

}