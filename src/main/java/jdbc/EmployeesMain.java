package jdbc;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeesMain {

    //1. DataSource - setUrl, SetUser, setPassword
    //2. dataSource.getConnection()
    //3. PreapredStatement
    //4. ExecuteUptade('sql kifejezés')
    //5. TWR és kivételkezelés SQLException
    public static void main(String[] args) throws IOException{
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
        /*employeesDao.createEmployee("John Doe");
        employeesDao.createEmployee("Jack Doe");
        employeesDao.createEmployee("Jane Doe");*/
        //System.out.println(employeesDao.listOddEmployeeNames());
        //System.out.println(employeesDao.listEmployeeNames());
        //System.out.println(employeesDao.findEmployeeById(2));
        //employeesDao.updateMaleNames();

        String filename = "training360.png";
     /*   try (InputStream is = Files.newInputStream(Path.of(filename))) {
            employeesDao.saveImage(filename, is);

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }*/

        InputStream is =employeesDao.getImageByName(filename);
        BufferedOutputStream os = new BufferedOutputStream(Files.newOutputStream(Path.of("proba.png")));
        byte[] buffer = new byte[10000];

        is.read(buffer);
        os.write(buffer);


    }
}
