package vaccinationmanager.dao;

import vaccinationmanager.operations.*;

import javax.sql.DataSource;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VaccinationsDao {

    public static final DataValidation DATA_VALIDATION = new DataValidation();

    private DataSource dataSource;

    public VaccinationsDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void saveCitizen(List<Citizen> citizens) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement("insert into citizens (citizen_name, zip, age, email, taj, number_of_vaccination) values(?,?,?,?,?,?)")) {
            for (Citizen citizen : citizens) {
                ps.setString(1, citizen.getName());
                ps.setString(2, citizen.getPostalCode());
                ps.setInt(3, citizen.getAge());
                ps.setString(4, citizen.getEmail());
                ps.setString(5, citizen.getSocSecNumber());
                ps.setInt(6, 0);
                ps.executeUpdate();
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }


    public String queryCity(String postalCode) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement("select city from cities where zip = ?")) {
            ps.setString(1, postalCode);
            return getCityByPreparedStatement(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }

    private String getCityByPreparedStatement(PreparedStatement ps) throws SQLException {
        try (
                ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString(1);
            }
            throw new IllegalArgumentException("Az irányítószám nincs az adatbázisban");
        }
    }


    public VaccinationDataByCitizen queryVaccinationDataByCitizenBySocSecNumber(String socSecNumber) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement("select citizen_id, number_of_vaccination, last_vaccination from citizens where taj = ?")) {
            ps.setString(1, socSecNumber);
            return getNumberOfVaccinationsByPreparedStatement(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }

    private VaccinationDataByCitizen getNumberOfVaccinationsByPreparedStatement(PreparedStatement ps) throws SQLException {
        try (
                ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                long id = rs.getLong(1);
                int numberOfVaccinations = rs.getInt(2);
                LocalDateTime lastVaccination = null;
                if (rs.getTimestamp(3) != null) {
                    lastVaccination = rs.getTimestamp(3).toLocalDateTime();
                }
                return new VaccinationDataByCitizen(id, numberOfVaccinations, lastVaccination);
            }
            throw new IllegalStateException("Cannot query id");
        }
    }


    public void saveVaccination(List<VaccinationDataByCitizen> vaccinationDataByCitizenList) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps1 = connection.prepareStatement("update citizens set number_of_vaccination = ?, last_vaccination = ? WHERE citizen_id = ?");
                PreparedStatement ps2 = connection.prepareStatement("insert into vaccinations (citizen_id, vaccination_date, status, vaccination_type) values (?,?,?,?)")) {

            for (VaccinationDataByCitizen vdc : vaccinationDataByCitizenList) {
                ps1.setInt(1, vdc.getNumberOfVaccinations());
                ps1.setTimestamp(2, Timestamp.valueOf(vdc.getLastVaccination()));
                ps1.setLong(3, vdc.getId());

                ps2.setLong(1, vdc.getId());
                ps2.setTimestamp(2, Timestamp.valueOf(vdc.getLastVaccination()));
                ps2.setString(3, VaccinationStatus.COMPLETED.name());
                ps2.setString(4, vdc.getVaccinationsType());

                ps1.executeUpdate();
                ps2.executeUpdate();
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }


    public String queryFirstVaccinesType(long id) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement("select vaccination_type from vaccinations where citizen_id = ?")) {
            ps.setLong(1, id);
            return getFirstVaccinesTypeByPreparedStatement(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }


    private String getFirstVaccinesTypeByPreparedStatement(PreparedStatement ps) throws SQLException {
        try (
                ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString(1);
            }
        }
        throw new IllegalStateException("Cannot query type");
    }


    public List<Citizen> queryCitizensTobeVaccinatedByPostalCode(String postalCode) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement("select citizen_name, age, email, taj, number_of_vaccination, last_vaccination from citizens where zip = ?")) {
            ps.setString(1, postalCode);
            return getCitizensTobeVaccinatedByPostalCodeByPreparedStatement(ps, postalCode);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }


    }

    private List<Citizen> getCitizensTobeVaccinatedByPostalCodeByPreparedStatement(PreparedStatement ps, String postalCode) throws SQLException {
        List<Citizen> citizensTobeVaccinatedByPostalCode = new ArrayList<>();
        try (
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString(1);
                int age = rs.getInt(2);
                String email = rs.getString(3);
                String socSecNumber = rs.getString(4);
                int numberOfVaccinations = rs.getInt(5);
                LocalDateTime lastVaccination = null;
                if (rs.getTimestamp(6) != null) {
                    lastVaccination = rs.getTimestamp(6).toLocalDateTime();
                }
                Citizen citizen = new Citizen(name, postalCode, age, email, socSecNumber, numberOfVaccinations, lastVaccination);

                if (DATA_VALIDATION.checkIfCanBeVaccinated(citizen)) {
                    citizensTobeVaccinatedByPostalCode.add(citizen);
                }
            }
            return citizensTobeVaccinatedByPostalCode;
        }
    }

    public long queryCitizenIdBySocSecNumber(String socSecNumber) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement("select citizen_id from citizens where taj = ?")) {
            ps.setString(1, socSecNumber);
            return getCitizenIdByPreparedStatement(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }


    private long getCitizenIdByPreparedStatement(PreparedStatement ps) throws SQLException {
        try (
                ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getLong(1);
            }
        }
        throw new InvalidDataInputException();
    }


    public void saveCanceledVaccination(String socSecNumber, LocalDateTime timeOfSchedule, String noteOfCancellation) {
        long id = queryCitizenIdBySocSecNumber(socSecNumber);
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement("insert into vaccinations (citizen_id, vaccination_date, status, note) values (?,?,?,?)")) {
            ps.setLong(1, id);
            ps.setTimestamp(2, Timestamp.valueOf(timeOfSchedule));
            ps.setString(3, VaccinationStatus.CANCELED.name());
            ps.setString(4, noteOfCancellation);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }


    public List<VaccinationReport> queryReport(String postalCode) {
        List<VaccinationReport> vaccinationReports = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM citizens WHERE number_of_vaccination = ? AND zip = ?")) {
            for (int i = 0; i < 3; i++) {
                ps.setInt(1, i);
                ps.setString(2, postalCode);
                long numberOfCitizens = getReportPreparedStatement(ps);
                int numberOfVaccinations = i;
                vaccinationReports.add(new VaccinationReport(postalCode, numberOfVaccinations, numberOfCitizens));
            }
            return vaccinationReports;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }


    private long getReportPreparedStatement(PreparedStatement ps) throws SQLException {
        try (
                ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getLong(1);
            }
        }
        throw new IllegalStateException("Cannot query");
    }
}







/*    CREATE schema if not exists vaccinationmanager default character set utf8 collate utf8_hungarian_ci;
        create user 'vaccinationmanager'@'localhost' identified by 'vaccinationmanager';
        grant all on *.* to 'vaccinationmanager'@'localhost';

        USE `vaccinationmanager`;
        CREATE TABLE `citizens`(
        `citizen_id` BIGINT AUTO_INCREMENT,
        `citizen_name` VARCHAR(200) NOT NULL,
        `zip` CHAR(2) NOT NULL,
        `age` BIGINT NOT NULL,
        `email` VARCHAR(200),
        `taj` VARCHAR(10),
        `number_of_vaccination` BIGINT,
        `last_vaccination` DATETIME,
        PRIMARY KEY (`citizen_id`)
        );

        CREATE TABLE `vaccinations`(
	`vaccination_id` BIGINT AUTO_INCREMENT,
	`citizen_id` BIGINT NOT NULL,
	`vaccination_date` DATETIME NOT NULL,
	`status` VARCHAR(10),
	`note` VARCHAR(200),
	`vaccination_type` VARCHAR(200),
	PRIMARY KEY (`vaccination_id`),
	FOREIGN KEY (`citizen_id`) REFERENCES `citizens` (`citizen_id`)
	);


CREATE TABLE `cities`(
	`city_id` BIGINT AUTO_INCREMENT,
	`zip` VARCHAR(4) NOT NULL,
	`city` VARCHAR(40) NOT NULL,
	PRIMARY KEY (`city_id`)
	);




    SELECT COUNT(*) FROM citizens WHERE number_of_vaccination = 1
        AND zip = 2200;

        */