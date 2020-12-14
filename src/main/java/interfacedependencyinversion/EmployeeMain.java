package interfacedependencyinversion;

public class EmployeeMain {

    public static void main(String[] args) {
        Employee employee = new Employee(10_000, new PercentBonusCalculator());
        System.out.println(employee.getBonus());

        Employee employee2 = new Employee(10_000, new FixedBonusCalculator());
        System.out.println(employee.getBonus());
    }
}
