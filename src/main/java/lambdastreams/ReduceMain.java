package lambdastreams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReduceMain {


    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(new Employee("Géza bá", 300),new Employee("Béla bá", 50), new Employee("Nándi", 100), new Employee("Árpi", 10));
        int count = employees.stream().reduce(0,
                (i, e) -> i + e.getName().length(),
                (i1, i2) -> i1+i2);
        System.out.println(count);


        //Stream employeeStream = Stream.of(new Employee("Géza bá", 300),new Employee("Béla bá", 50), new Employee("Nándi", 100), new Employee("Árpi", 10));

        NameCounter nameCounter = employees.stream().reduce(new NameCounter(),
                (nc, e) -> nc.add(e),
                (nc1, nc2) -> nc1.add(nc2)
               );
        System.out.println(nameCounter.getTwoPartName());



        NameCounter nameCounter2 = employees.stream().collect(NameCounter::new,
                (nc, e) -> nc.add(e),
                (nc1, nc2) -> nc1.add(nc2)
        );
        System.out.println(nameCounter.getTwoPartName());

    }
}
