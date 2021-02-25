package jdbc;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindByIdMain {

    //1. DataSource és setek
    //2. Connection kreálás Datasource alapján
    //3. PreparedStatement -> con.PrepStatement(sql?)
    //4. TWR
    //.5 PreparedStatement beparaméterezés -> ps.setXXX()
    //6. ResultSet -> stmt.executeQuery()
    //7. mert a ResultSet kreálást már megelőzte egy metódus, ezért a ResultSetnek külön TWR kell
    //8. if next(), sout
    //9. Exceptionok, külön IllegalArg arra, ha nincs találat
    //10. main + kiszervezés két külön metódusokba: SelectNameById() és SelectNameByPreparedStatement()


    public static void main(String[] args) {
        MariaDbDataSource dbDataSource;
        try {
            dbDataSource = new MariaDbDataSource();
            dbDataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dbDataSource.setUser("employees");
            dbDataSource.setPassword("employees");

            new FindByIdMain().SelectNameById(dbDataSource,1);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot create data source", se);
        }
    }



    public void SelectNameById(MariaDbDataSource dbDataSource, long id) {
        try (
                Connection con = dbDataSource.getConnection();
                PreparedStatement ps = con.prepareStatement("select emp_name from employees where id=?")) {
            ps.setLong(1, 2L);

            SelectNameByPreparedStatement(ps);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }

    private void SelectNameByPreparedStatement(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                String name = rs.getString("emp_name");
                System.out.println(name);

            } else {
                throw new IllegalArgumentException("Cannot find record with given id");
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }

}
