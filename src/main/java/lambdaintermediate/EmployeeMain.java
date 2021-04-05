package lambdaintermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeMain {


    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(new Employee("Gézabá", 300), new Employee("Bélabá", 50),
                new Employee("Nándi", 100), new Employee("Árpi", 10), new Employee("Gézabá", 300));

        // FILTER
        List<Employee> filtered = employees.stream()
                .filter(employee -> employee.getName().length() > 4)
                .collect(Collectors.toList());
        //System.out.println(filtered);

        // DISTINCT
        List<Employee> filtered2 = employees.stream()
                .distinct().collect(Collectors.toList());
        //System.out.println(filtered2);


        // LIMIT ÉS SKIP
        Stream<Double> integerStream = Stream.generate(Math::random);
        integerStream.limit(5).forEach(System.out::println);

        List<Integer> ints = Stream.iterate(1, n -> n + 2)
                .skip(2L).limit(3)
                .collect(Collectors.toList());
        //System.out.println(ints);

        //MAP
        List<String> names = employees.stream()
                .map(employee -> employee.getName())
                .peek(System.out::println)
                .limit(3)
                .sorted(Comparator.comparing(s -> s.length()))
                .collect(Collectors.toList());
        System.out.println(names);

        //FLATMAP
        List<String> names2 = Arrays.asList("Muci", "Jani", "Zoli");
        List<String> names3 = Arrays.asList("Lali", "Pali", "Gyuri");

        Stream<List<String>> listStream = Stream.of(names2, names3);
        List<String> union = listStream.flatMap(l -> l.stream()).collect(Collectors.toList());
        System.out.println(union);






    }



}
