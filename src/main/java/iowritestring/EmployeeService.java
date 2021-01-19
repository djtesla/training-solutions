package iowritestring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class EmployeeService {

    public static void main(String[] args) {

        Path file = Path.of("src","main", "java", "iowritestring", "employees.txt");


        List<String> names = List.of("Gézám", "Jucóm", "Bélám");
        try {

            Files.write(file, List.of("Apacuka", "Paréj"), StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }

    }
}

