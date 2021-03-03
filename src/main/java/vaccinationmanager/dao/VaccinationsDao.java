package vaccinationmanager.dao;

import vaccinationmanager.operations.Citizen;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class VaccinationsDao {

    private DataSource dataSource;

    public VaccinationsDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void saveCitizen(List<Citizen> citizens) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement("insert into citizens (citizen_name, zip, age, email, taj) values(?,?,?,?,?)")) {
            for (Citizen citizen : citizens) {
                ps.setString(1, citizen.getName());
                ps.setString(2, citizen.getPostalCode());
                ps.setInt(3, citizen.getAge());
                ps.setString(4, citizen.getEmail());
                ps.setString(5, citizen.getSocSecNumber());
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
           ps.setString(1,postalCode);
           return getCityByPreparedStatement(ps);
       } catch (SQLException se) {
           throw new IllegalStateException("Cannot query", se);
       }
    }


    private String getCityByPreparedStatement(PreparedStatement ps) throws SQLException {
        try(
                ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString(1);
            }
            throw new IllegalArgumentException("Az irányítószám nincs az adatbázisban");
        }
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
        */

