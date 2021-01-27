package week13d01;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CitiesTest {

    @Test

    public void getLongestCityNameTest() {


        String fileName = "iranyitoszamok-varosok-2021.csv";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/" + fileName)))) {

            assertEquals("Jászfelsőszentgyörgy", new Cities().getLongestCityName(reader));

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }


        Path path = Path.of("iranyitoszamok-varosok-2021.csv");
        try (BufferedReader reader = Files.newBufferedReader(path)) {

            assertEquals("Jászfelsőszentgyörgy", new Cities().getLongestCityName(reader));

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }


    }

}