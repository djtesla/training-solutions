package iowriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class EmployeeService {

    public static void main(String[] args) {



        try (BufferedReader reader = new BufferedReader(new InputStreamReader(EmployeeService.class.getResourceAsStream("/employees.txt")))) {

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }


}