package week14d04.senior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class EmployeeTransformOperations {



    public List<Employee> transformToUpperCased(List<Employee> employees) {
        return employees.stream()
                .map(employee -> new Employee(employee.getName().toUpperCase())).
                collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee("géza"),
                new Employee("béza"),
                new Employee("léza"),
                new Employee("méla"));
        System.out.println(new EmployeeTransformOperations().transformToUpperCased(employees));
    }


}
