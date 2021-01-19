package ioreadwritebytes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EmployeeService {

    public static void main(String[] args) {
        Path file = Path.of("data.dat");


        try {
            Files.write(file, new byte[] {97, 98, 99});
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

    }

 




}
