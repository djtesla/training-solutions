package jdbc;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {

    private DataSource dataSource;

    public EmployeesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createEmployee(String name) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("insert into employees(emp_name) values (?)")) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }


    public List<String> listEmployeeNames() {
        List<String> names;
        try (
                Connection con = dataSource.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select emp_name from employees")
        ) {
            names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("emp_name");
                names.add(name);
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
        return names;
    }


    public String findEmployeeById(long id) {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement("select emp_name from employees where id=?")) {
            ps.setLong(1, id);
            return SelectNameByPreparedStatement(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }


    private String SelectNameByPreparedStatement(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("emp_name");
            } else {
                throw new IllegalArgumentException("Cannot find record with given id");
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }


}
