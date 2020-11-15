package stringconcat;

import javax.xml.namespace.QName;
import java.util.Scanner;

public class Employee {

    private String name;
    private String job;
    private int salary;

    public Employee(String name, String job, int salary) {

        if (name == null || name.isEmpty())  {
            throw new IllegalArgumentException("Name must not be empty.");
        }
        this.name = name;


        if (job == null || job.isEmpty()) {
            throw new IllegalArgumentException("Job must not be empty.");
        }
        this.job = job;


        if (salary % 1000 != 0 || salary < 0) {
            throw new IllegalArgumentException("Salary must be positive and a multiple of 1000.");
        }
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " - " + job + " - " + salary + " Ft";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int salaryInput = 0;
        do {
            System.out.println("Add meg a salaryt: ");
            salaryInput = scanner.nextInt();

            try {
                Employee employee = new Employee("Nagy Árpi", "falfestékszáradásfigyelő", salaryInput);
                System.out.println(employee);
            } catch (IllegalArgumentException e) {
                System.out.println("Salary is not a multiple of 1000!");

            }
        } while (salaryInput % 1000 != 0);

    }

}
