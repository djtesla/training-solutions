package vizsgafelkészülés03;

import java.util.Objects;

public class Employee implements Comparable<Employee> {

    private String name;
    private int salary;
    private Location location;

    public Employee() {
    }

    public Employee(String name, int salary, Location location) {
        this.name = name;
        this.salary = salary;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }



    public void meti() {


    }


    public static void proba() {
    }


    public Location getLocation() {
        return new Location(location.getX(), location.getY());
    }

    @Override
    public int compareTo(Employee o) {
        return location.compareTo(o.location);
    }

    @Override
    public String toString() {
        return
                "name='" + name + ", salary=" + salary + ", location=" + location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(location, employee.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    public void tri() {






    }
}
