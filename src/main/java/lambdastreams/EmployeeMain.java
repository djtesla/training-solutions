package lambdastreams;

import java.util.*;
import java.util.stream.Stream;

public class EmployeeMain {


    public static void main(String[] args) {


        List<Employee> employees = Arrays.asList(new Employee("Gézabá", 300),new Employee("Bélaba", 50), new Employee("Nándi", 100), new Employee("Árpi", 10));


        // LÉTREHOZÁS, COUNT
        Stream<Employee> emptyList = Stream.empty();
        Stream<Employee> employeeStream1 = Stream.of(new Employee("Géza", 300),new Employee("Béla", 50), new Employee("Nándi", 100), new Employee("Árpi", 10));
        Stream<Employee> employeeStream2 = employees.stream();
        System.out.println(employeeStream2.count());
        Stream<Employee> employeeStream3 = employees.parallelStream();
        System.out.println(emptyList.count());


        //ZÁRÓ MŰVELETEK = TERMINAL OPERATIONS
        // simán
        // Optional<Employee> employeeOptional = employeeStream3.min((e1, e2) -> Integer.valueOf(e1.getSalary()).compareTo(Integer.valueOf(e2.getSalary())));

        //Comparator.comparing() - lambda
        //Optional<Employee> employeeOptional = employeeStream3.min(Comparator.comparing(employee -> employee.getName()));

        //Comparator.comparing() - lambda - metódus referencia
        Optional<Employee> employeeOptional = employeeStream3.min(Comparator.comparing(Employee::getName));
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            System.out.println(employee.getName());
        }

        //Comparator.comparing() - többlépcsős comparing, sorrtal; közbülsű művelet, stream nem szűnik meg!
        employeeStream1.sorted(Comparator.comparing(Employee::getName).thenComparing(Comparator.comparing(Employee::getSalary)));


        // FINDANY(), FINDFIRST()
        Stream<Employee> employeeStream4 = employees.stream();
      /*  Optional<Employee> e3 = employeeStream4.findFirst();
        if (e3.isPresent()) {
            System.out.println();
        }*/

        Employee e4 = employeeStream4.findFirst().orElse(new Employee("Nusi", 110));

        // XXXMATCH()

        Stream<Employee> employeeStream5 = employees.stream();
        boolean b = employeeStream5.allMatch(employee -> employee.getName().length() > 5);
        System.out.println(b);


        // FOREACH()
        Stream<Employee> employeeStream6 = employees.stream();
        employeeStream6.forEach(employee -> System.out.println(employee.setName(employee.getName().toUpperCase())));


    }
}
