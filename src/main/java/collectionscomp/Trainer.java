package collectionscomp;

import java.util.Comparator;

public class Trainer implements Comparable<Trainer> {

    private String name;
    private int salary;

    public Trainer(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Trainer t) {
        return this.getSalary()-t.getSalary();
    }

    @Override
    public String toString() {
        return "name='" + name + ", salary=" + salary;
    }


}
