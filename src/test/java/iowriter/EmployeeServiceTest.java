package iowriter;

import org.junit.jupiter.api.Test;


import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

   
    @Test
    public void testWriteEmployeesToFile () {

        List <String> employees = List.of("John","Jane","Jack");

        new EmployeeService().writeEmployeesToFile(employees, Path.of(""));
    }

}