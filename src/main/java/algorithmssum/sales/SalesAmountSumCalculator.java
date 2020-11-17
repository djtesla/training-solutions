package algorithmssum.sales;

import java.util.List;

public class SalesAmountSumCalculator {


    public int sumSalesAmount(List<Salesperson> salesPersons) {
        int sum =0;
        for (Salesperson salesperson : salesPersons) {
            sum += salesperson.getAmount();
        }
        return sum;
    }


            public static void main(String[] args) {

            SalesAmountSumCalculator salesAmountSumCalculator = new SalesAmountSumCalculator();

            Company company = new Company();

            company.addPerson(new Salesperson("Bill Gates", 5_000_000));
            company.addPerson(new Salesperson("Steve Jobs", 4_000_000));
            company.addPerson(new Salesperson("Elon Musk", 3_000_000));
            company.addPerson(new Salesperson("Gattyán György", 2_000_000));

                System.out.println(salesAmountSumCalculator.sumSalesAmount(company.getSalesPersons()));


    }
}
