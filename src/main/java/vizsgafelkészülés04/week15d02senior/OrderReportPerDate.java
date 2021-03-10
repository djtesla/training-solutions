package vizsgafelkészülés04.week15d02senior;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderReportPerDate {

    private LocalDate dateOfOrders;
    private List<PizzaOrder> pizzaOrders = new ArrayList<>();

    public OrderReportPerDate(LocalDate dateOfOrders) {
        this.dateOfOrders = dateOfOrders;
    }

    public void addPizzaOrder(PizzaOrder pizzaOrder) {
        pizzaOrders.add(pizzaOrder);
    }

    public LocalDate getDateOfOrders() {
        return dateOfOrders;
    }

    public List<PizzaOrder> getPizzaOrders() {
        return pizzaOrders;
    }

    @Override
    public String toString() {
        return "dateOfOrders=" + dateOfOrders + ", pizzaOrders=" + pizzaOrders;

    }
}
