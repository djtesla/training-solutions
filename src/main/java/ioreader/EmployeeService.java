package ioreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class EmployeeService {


    public static void main(String[] args) {

        //1. Path
        Path path = Path.of("employees.txt");
        //2. new BufferedReader
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }


    }
}
