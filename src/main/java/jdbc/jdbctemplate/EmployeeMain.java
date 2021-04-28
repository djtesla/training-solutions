package jdbc.jdbctemplate;


import org.mariadb.jdbc.MariaDbDataSource;


import java.sql.SQLException;

public class EmployeeMain {

    public static void main(String[] args) throws SQLException {

        EmployeesDao employeesDao;
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");

            employeesDao = new EmployeesDao(dataSource);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect");
        }

    //employeesDao.createEmployee("Géza");
        //System.out.println(employeesDao.listEmployeeNames());
        //System.out.println(employeesDao.createEmployeeAndGetId("Joci"));
        System.out.println(employeesDao.findEmployeeNameById(5));


    }





}
