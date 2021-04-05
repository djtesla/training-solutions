package segéd.interfaces;

public class Employee {

    private String name;
    private int salary;
    private BonusCalculator bonusCalculator;

    public Employee(String name, int salary, BonusCalculator bonusCalculator) {
        this.name = name;
        this.salary = salary;
        this.bonusCalculator = bonusCalculator;
    }

    public double calculateBonus () {
        return bonusCalculator.getBonus(salary);
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Géza", 100_000, new ManagerBonus());
        Employee employee2 = new Employee("Joci", 100_000, new BaseBonus());

        System.out.println(employee1.calculateBonus());
        System.out.println(employee2.calculateBonus());
    }
}
