package jdbc;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeesDaoTest {

    private EmployeesDao employeesDao;

    @BeforeEach
    public void init() {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert");
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        employeesDao = new EmployeesDao(dataSource);


    }

    @Test
    public void testInsert() {
        employeesDao.createEmployee("Joci");
        assertEquals("[Joci]", employeesDao.listEmployeeNames().toString());
    }

    @Test
    public void testQueryId() {
        employeesDao.createEmployee("Jane Doe");
        long id = employeesDao.createEmployee("Joci");
        employeesDao.createEmployee("Jack Doe");
        assertEquals("Joci", employeesDao.findEmployeeById(id));
    }

    @Test
    public void testCreateEmployees() {
        employeesDao.createEmployees(List.of("Gábor", "Áron", "Rézfaszú Bagoly"));
        assertEquals(List.of("Gábor", "Áron", "Rézfaszú Bagoly"), employeesDao.listEmployeeNames());
    }


    @Test
    public void testCreateEmployeesWithException() {
        employeesDao.createEmployees(List.of("Gábor", "Áron", "xRézfaszú Bagoly"));
        assertEquals(Collections.emptyList(), employeesDao.listEmployeeNames());
    }


}
