package postcoursegyak.eniko;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


public class AnimalDao {

    JdbcTemplate jdbcTemplate;

    public AnimalDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }




    public List<String> getAnimalNames () {
        return jdbcTemplate.query("select animal_name from animals", ((resultSet, i) -> resultSet.getString("animal_name")));

    }


    public static void main(String[] args) {

        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/animals?useUnicode=true");
            dataSource.setUser("animals");
            dataSource.setPassword("animals");
        } catch (SQLException sqe) {
            throw new IllegalStateException("", sqe);
        }

        System.out.println(new AnimalDao(dataSource).getAnimalNames());




    }
}
