package jdbc;

import javax.sql.DataSource;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeesDao {

    private DataSource dataSource;

    public EmployeesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public long createEmployee(String name) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("insert into employees(emp_name) values (?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            return executeAnsGetGeneratedKey(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }


    public void createEmployees(List<String> names) {
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement("insert into employees(emp_name) values (?)")) {
                for (String name : names) {
                    if (name.startsWith("x")) {
                        throw new IllegalArgumentException("");
                    }
                    stmt.setString(1, name);
                    stmt.executeUpdate();
                }
                conn.commit();
            } catch (IllegalArgumentException iae) {
                conn.rollback();
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }


    private long executeAnsGetGeneratedKey(PreparedStatement stmt) {
        try (
                ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getLong(1);
            } else {
                throw new SQLException("No key has been generated");
            }
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


    public List<String> listOddEmployeeNames() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("select emp_name from employees", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = ps.executeQuery()) {
            return getListOfNamesPerPreparedStatement(rs);
        } catch (SQLException sqe) {
            throw new IllegalStateException("Cannot query");
        }

    }

    private List<String> getListOfNamesPerPreparedStatement(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            return Collections.emptyList();
        }
        List<String> names = new ArrayList<>();
        names.add(rs.getString("emp_name"));
        while (rs.relative(2)) {
            names.add(rs.getString("emp_name"));

        }
        return names;
    }


    public void updateMaleNames() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("select id, emp_name from employees", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = ps.executeQuery()) {
            updateResultSet(rs);
        } catch (SQLException sqe) {
            throw new IllegalStateException("Cannot query", sqe);
        }
    }

    private void updateResultSet(ResultSet rs) throws SQLException {
        while (rs.next()) {
            String name = rs.getString("emp_name");
            if (name.startsWith("Jane")) {
            } else {
                rs.updateString("emp_name", "Mr. " + name);
                rs.updateRow();
            }
        }


    }


    public void saveImage(String fileName, InputStream image) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement("insert into images (filename, content) values (?,?)")) {
            ps.setString(1, fileName);
            Blob blob = connection.createBlob();
            fillBlob(image, blob);
            ps.setBlob(2, blob);
            ps.executeUpdate();
        } catch (SQLException sqe) {
            throw new IllegalStateException("Cannot connect", sqe);
        }
    }


    private void fillBlob(InputStream image, Blob blob) {
        try (OutputStream os = blob.setBinaryStream(1);
             BufferedInputStream is = new BufferedInputStream(image)) {
            is.transferTo(os);
        } catch (IOException | SQLException e) {
            throw new IllegalStateException("Error when creating blob", e);
        }
    }

    public InputStream getImageByName(String name) {
        try (
        Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement("select content from images where filename =?") ) {
            ps.setString(1, name);
            return readBlob(ps);


        } catch (SQLException sqe) {
            throw new IllegalStateException("Cannot query", sqe);
        }
    }


    private InputStream readBlob(PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getBlob("content").getBinaryStream();
        }
        throw new IllegalStateException("Not found");
    }


}