package gyakorlás.vizsga2felkészülés;

public class EmployeeMain {

    public static void main(String[] args) {


        Employee employee1 = new Employee(10000, new PercentBonusCalculator());
        Employee employee2 = new Employee(10000, new FixedBonusCalculator());

        System.out.println(employee1.getBonus());
        System.out.println(employee2.getBonus());
    }
}

