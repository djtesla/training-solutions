package introdate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {


        Employee employee = new Employee("Ernő Zámbó", 1982, 9, 23);
        System.out.println(employee.getBeginEmployment());
        System.out.println(employee.getDateOfBirth());
    }
}
