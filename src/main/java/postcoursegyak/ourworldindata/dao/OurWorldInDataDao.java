package postcoursegyak.ourworldindata.dao;

import postcoursegyak.ourworldindata.operations.DailyEntry;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class OurWorldInDataDao {

    private DataSource dataSource;

    public OurWorldInDataDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void uploadEntries(List<DailyEntry> entries) {
        int count = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("insert into ourworldindatacovid (continent, location, entry_date, total_cases, new_cases, total_deaths, new_deaths, icu_patients, hosp_patients, people_vaccinated, people_fully_vaccinated, new_vaccinations, population) values (?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            for (DailyEntry entry : entries) {
                count++;
                ps.setString(1, entry.getContinent());
                ps.setString(2, entry.getLocation());
                ps.setDate(3, Date.valueOf(entry.getDate()));
                ps.setInt(4, entry.getTotalCases());
                ps.setInt(5, entry.getNewCases());
                ps.setInt(6, entry.getTotalDeaths());
                ps.setInt(7, entry.getNewDeaths());
                ps.setInt(8, entry.getIcuPatients());
                ps.setInt(9, entry.getHospPatients());
                ps.setInt(10, entry.getPeopleVaccinated());
                ps.setInt(11, entry.getPeopleFullyVaccinated());
                ps.setInt(12, entry.getNewVaccinations());
                ps.setInt(13, entry.getPopulation());
                ps.executeUpdate();
                long id = getIdByPreparedStatement(ps);
                entry.setId(id);
            }
            System.out.println(count);
        } catch (SQLException sqe) {
            throw new IllegalStateException("Cannot connect", sqe);
        }
    }


    private long getIdByPreparedStatement(PreparedStatement ps) throws SQLException {
        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getLong(1);
            }
            throw new IllegalArgumentException("Cannot query");
        }
    }

}
