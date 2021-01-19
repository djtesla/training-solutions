package ioreadstring;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EmployeeService {


    public static void main(String[] args) {

        Path path = Path.of("employees.txt");
        List<String> content = null;
        try {
            content = Files.readAllLines(path, Charset.forName("ISO-8859-2"));
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

        System.out.println(content);
    }
}
