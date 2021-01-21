package iowriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class EmployeeService {

    public  void writeEmployeesToFile(List<String> employees, Path file) {


        try(BufferedWriter writer = Files.newBufferedWriter(file)) {

            for (String employee : employees) {
                writer.write(employee + "\n");

            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }






    }





}