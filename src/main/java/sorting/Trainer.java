package sorting;

public class Trainer {

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
    public String toString() {
        return "name='" + name + ", salary=" + salary;
    }


}
