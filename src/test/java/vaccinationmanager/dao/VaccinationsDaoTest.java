package vaccinationmanager.dao;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationsDaoTest {

    VaccinationsDao vaccinationsDao;

    @BeforeEach
    public void init () {

        MariaDbDataSource dataSource = new MariaDbDataSource();

        try {

            dataSource.setUrl("jdbc:mariadb://localhost:3306/vaccinationmanager?useUnicode=true");
            dataSource.setUser("vaccinationmanager");
            dataSource.setPassword("vaccinationmanager");


        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect");
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();


    }



    @Test
    public void test1() {

    }

    @Test
    public void test2() {

    }

    @Test
    public void test3() {

    }

}