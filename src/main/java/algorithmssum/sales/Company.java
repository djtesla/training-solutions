package algorithmssum.sales;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Salesperson> salesPersons = new ArrayList<>();

    public List<Salesperson> getSalesPersons() {
        return salesPersons;
    }

    public void addPerson(Salesperson salesperson) {
        salesPersons.add(salesperson);
    }



}
