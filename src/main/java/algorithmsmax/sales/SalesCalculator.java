package algorithmsmax.sales;

import java.util.ArrayList;
import java.util.List;

public class SalesCalculator {

    public Salesperson personWithBiggestAmount(List<Salesperson> salesPersons) {

        Salesperson person = null;


        for (Salesperson salesperson : salesPersons) {

            if (person == null || salesperson.getAmount() > person.getAmount())
                person = salesperson;
        }
        return person;
    }


    public Salesperson personWithBiggestPositiveDifference(List<Salesperson> salesPersons) {
        Salesperson person = null;

        for (Salesperson salesperson : salesPersons) {

            if (person == null || salesperson.getAmount() - salesperson.getTarget() > 0
                    && salesperson.getAmount() - salesperson.getTarget() > person.getAmount() - person.getTarget()) {
                person = salesperson;
            }
        }
        return person;
    }


    public Salesperson personWithBiggestNegativeDifference(List<Salesperson> salesPersons) {
        Salesperson person = null;

        for (Salesperson salesperson : salesPersons) {

            if (person == null || salesperson.getAmount() - salesperson.getTarget() < 0
                    && salesperson.getAmount() - salesperson.getTarget() < person.getAmount() - person.getTarget()) {
                person = salesperson;
            }
        }
        return person;
    }

    public static void main(String[] args) {
        List<Salesperson> salesPersons = new ArrayList<>();

        salesPersons.add(new Salesperson("Béci", 1500, 1000));
        salesPersons.add(new Salesperson("Jocó", 1800, 1600));
        salesPersons.add(new Salesperson("Gézu", 1100, 1000));
        salesPersons.add(new Salesperson("Magdi", 900, 1000));
        salesPersons.add(new Salesperson("Popei", 800, 1000));
        salesPersons.add(new Salesperson("Miska", 700, 1000));

        SalesCalculator salesCalculator = new SalesCalculator();

        System.out.println(salesCalculator.personWithBiggestAmount(salesPersons).getName());
        System.out.println(salesCalculator.personWithBiggestPositiveDifference(salesPersons).getName());
        System.out.println(salesCalculator.personWithBiggestPositiveDifference(salesPersons).getName());

    }
}
