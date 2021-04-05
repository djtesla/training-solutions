package lambdaprimitives;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeService {


    public List<Employee> generateEmployees(String prefix, int number) {
        return IntStream.range(0, number)
                .mapToObj(i -> new Employee(prefix + " " + i, 0, null))
                .collect(Collectors.toList());
    }

    public int sumSalary(List<Employee> employees) {
        return employees.stream().mapToInt(Employee::getSalary).sum();
    }

    public Boundary getSalaryBoundaries(List<Employee> employees) {
        IntSummaryStatistics stat = employees.stream().mapToInt(Employee::getSalary).summaryStatistics();
        return new Boundary(stat.getMin(), stat.getMax());
    }


    public static void main(String[] args) {

        EmployeeService es = new EmployeeService();

        System.out.println(es.generateEmployees("John Doe", 2));

        List<Employee> employees = Arrays.asList(new Employee("John Doe", 100, null),
                new Employee("Jack Doe", 200, null),
                new Employee("Jane Doe", 300, null));

        System.out.println(es.sumSalary(employees));

        System.out.println(es.getSalaryBoundaries(employees));
    }


}
