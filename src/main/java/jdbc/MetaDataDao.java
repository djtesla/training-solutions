package jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetaDataDao {

    private DataSource dataSource;

    public MetaDataDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getTableNames() {
        try (
                Connection conn = dataSource.getConnection()) {
            DatabaseMetaData metaData = conn.getMetaData();
            return getTableNames(metaData);
        } catch (SQLException sqe) {
            throw new IllegalArgumentException("Cannot read table names", sqe);
        }

    }


    private List<String> getTableNames(DatabaseMetaData metaData) throws SQLException {
        try (ResultSet rs = metaData.getTables(null, null, null, null)) {
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString(3);
                names.add(name);
            }
            return names;
        }
    }



}
