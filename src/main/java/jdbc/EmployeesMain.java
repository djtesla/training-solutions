package jdbc;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeesMain {

    //1. DataSource - setUrl, SetUser, setPassword
    //2. dataSource.getConnection()
    //3. PreapredStatement
    //4. ExecuteUptade('sql kifejezés')
    //5. TWR és kivételkezelés SQLException
    public static void main(String[] args) {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert");
        }

        EmployeesDao employeesDao = new EmployeesDao(dataSource);
        employeesDao.createEmployee("John Doe");

        System.out.println(employeesDao.listEmployeeNames());
        System.out.println(employeesDao.findEmployeeById(2));

    }
}
