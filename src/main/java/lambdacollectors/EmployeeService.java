package lambdacollectors;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {


    //JOINING
    public String concatenateNames(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
    }


    //SUMMING
    public long sumSalaries(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.summingInt(Employee::getSalary));
    }


    //SUMMARIZING - STATISTICS
    public long sumSalariesWithSummarizingInt(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.summarizingInt(Employee::getSalary)).getSum();
    }


    //TOLIST
    public List<Employee> filterSalariesGreaterThan(List<Employee> employees, int boundary) {
        return employees.stream()
                .filter(e -> e.getSalary() > boundary)
                .collect(Collectors.toList());
    }


    //TOMAP
    public Map<Long, Employee> groupById(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(Employee::getId, e -> e));
    }


    //GROUPINGBY
    public Map<String, List<Employee>> groupByDivision(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDivision));
    }


    //GROUPINGBY, 2. PARAMÉTERE COLLECTOR
    public Map<String, Long> numberOfEmployeesPerDivision(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDivision, Collectors.counting()));
    }


    //PARTITIONINGBY
    public Map<Boolean, List<Employee>> partitionBySalary(List<Employee> employees, int boundary) {
        return employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > boundary));
    }


    //COLLECTORS.MAPPING - 2. PARAMÉTERE COLLECTOR
    public Map<String, Optional<Integer>> minSalaryByDivision(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDivision,
                        Collectors.mapping(Employee::getSalary, Collectors.minBy(Comparator.naturalOrder()))));

    }


    public static void main(String[] args) {
        EmployeeService es = new EmployeeService();
        List<Employee> employees = Arrays.asList(new Employee(1111, "John Doe", 100_000, "p2p"),
                new Employee(1112, "Jack Doe", 150_000, "p2p"),
                new Employee(1113, "Jane Doe", 200_000, "hr"),
                new Employee(1114, "Dan Doe", 500_000, "it"),
                new Employee(1115, "Black Doe", 130_000, "hr"));

        //System.out.println(es.concatenateNames(employees));
        //System.out.println(es.sumSalaries(employees));
        //System.out.println(es.sumSalariesWithSummarizingInt(employees));
        //System.out.println(es.filterSalariesGreaterThan(employees, 150_000));
        //System.out.println(es.groupById(employees));
        //System.out.println(es.groupByDivision(employees));
        //System.out.println(es.numberOfEmployeesPerDivision(employees));
        //System.out.println(es.partitionBySalary(employees, 200_000));
        System.out.println(es.minSalaryByDivision(employees));

    }
}
