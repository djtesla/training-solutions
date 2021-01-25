package iofilestest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    // OLyan met tesztelése, ami Pathot vár (fileba ír vagy fileból olvas; itt írás lesz
    //1. TemDir annotáció és atri; String lista; új file és path kreálás metódus hívás és temp fileba írás, assertelés

    @TempDir
    public Path tempDir;


    @Test
    public void writeTest () throws IOException {

        Path path = tempDir.resolve("employees.txt");

        List<String> employees = List.of("Géza Doe", "Béla Doe");

        new EmployeeService().writeEmployeesToFile(path, employees);

        List<String> lines = Files.readAllLines(path);

        assertEquals(2, lines.size());
        assertEquals("Béla Doe", lines.get(1));



    }

}