package clone.timesheet;

public class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(Employee another) {
        this.name = another.name;
    }


    public String getName() {
        return name;
    }
}
