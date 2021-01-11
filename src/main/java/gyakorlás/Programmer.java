package gyakorlás;

public class Programmer extends Employee {
    private double s;
    private double b;

    public Programmer(double s, double b) {
        super(s);
        this.s = s;
        this.b = b;
    }

    public double getSalary() {
        return s + b;
    }
}

