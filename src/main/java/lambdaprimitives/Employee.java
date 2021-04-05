package lambdaprimitives;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Employee {

    private String name;
    private int salary;
    private String cardNumber;

    public Employee(String name, int salary, String cardNumber) {
        this.name = name;
        this.salary = salary;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public String toString() {
        return
                "name='" + name + ", salary=" + salary +
                        ", cardNumber='" + cardNumber + '\'';

    }

}
