package gyakorlás;


import java.util.*;

public class Employee implements Comparable<Employee>{
    private int s;

    public Employee(double salary) {
        this.s = s;
    }

    public double getSalary() {
        return s;
    }


    @Override
    public int compareTo(Employee o) {
        return s - o.s;
    }

    public static void main(String[] args) {

        double c = 100000000.5;

    List<String> names = new ArrayList<>(Arrays.asList("csumi", "lali", "berni", "joci", "humi"));
    Set<String> names2 = new HashSet<>(names);

        System.out.println(names);
    System.out.println(Collections.binarySearch(names, "lali"));









    }



}