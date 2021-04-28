package postcoursegyak.ourworldindata.dao;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import postcoursegyak.ourworldindata.operations.DailyEntry;

public class DaoJdbcTemplate {

    JdbcTemplate jdbcTemplate;

    public DaoJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<DailyEntry> getLastFiveEntryPerCountry(String country) {

        return jdbcTemplate.query("select location, entry_date, new_cases from ourworldindatacovid where location=? order by entry_date desc limit 30", new RowMapper<DailyEntry>() {
            @Override
            public DailyEntry mapRow(ResultSet resultSet, int i) throws SQLException {
                String location = resultSet.getString("location");
                LocalDate date = resultSet.getDate("entry_date").toLocalDate();
                int newCases = resultSet.getInt("new_cases");

                return new DailyEntry(location,date,newCases);
            }
        },country);
    }


    public List<DailyEntry> getEntriesWithGivenDate(LocalDate date) {
        return jdbcTemplate.query("select location, new_cases from ourworldindatacovid where entry_date=?", new RowMapper<DailyEntry>() {
            @Override
            public DailyEntry mapRow(ResultSet resultSet, int i) throws SQLException {
                String location = resultSet.getString("location");
                int newCases = resultSet.getInt("new_cases");
                return new DailyEntry(location,date,newCases);
            }
        },date);
    }


    public DailyEntry getEntryWithMostNewCases(String location) {
        return jdbcTemplate.queryForObject("select entry_date, max(new_cases) from ourworldindatacovid WHERE location=?", (resultSet, i) -> {
            LocalDate date = resultSet.getDate("entry_date").toLocalDate();
            int newCases = resultSet.getInt("max(new_cases)");
            return new DailyEntry(location,date,newCases);
        },location);
    }



    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/ourworldindatacovid?useUnicode=true");
            dataSource.setUser("ourworldindatacovid");
            dataSource.setPassword("ourworldindatacovid");
        } catch (SQLException sqe) {
            throw new IllegalStateException("Cannot connect", sqe);
        }
        DaoJdbcTemplate tl = new DaoJdbcTemplate(dataSource);

        IntSummaryStatistics stat =tl.getLastFiveEntryPerCountry("Hungary").stream().mapToInt(DailyEntry::getNewCases).summaryStatistics();

        System.out.println("Legtöbb napi esetszám az elmúlt 30 napban: " + stat.getMax());
        System.out.println("Átlagos napi esetszám az elmúlt 30 napban: " + stat.getAverage());


        System.out.println(tl.getEntriesWithGivenDate(LocalDate.of(2021,04,14))
                .stream()
                .sorted(Comparator.comparing(DailyEntry::getNewCases).reversed())
                .limit(10)
                .collect(Collectors.toList()));

        System.out.println(tl.getEntryWithMostNewCases("Italy"));


        System.out.println(tl.getEntriesWithGivenDate(LocalDate.of(2020,04,01)).stream()
                .mapToInt(DailyEntry::getNewCases).sum());
    }


}
