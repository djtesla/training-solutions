package lambdacollectors;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cafe {

    private List<CoffeeOrder> coffeeOrders;

    public Cafe(List<CoffeeOrder> coffeeOrders) {
        this.coffeeOrders = coffeeOrders;
    }

    public List<CoffeeOrder> getCoffeeOrders() {
        return coffeeOrders;
    }

    public void addCoffeeOrder(CoffeeOrder coffeeOrder) {
        coffeeOrders.add(coffeeOrder);
    }

    // az eladott kávék mennyiségét adja vissza kávétípusonként
    public Map<CoffeeType, Long> getCountByCoffeeType() {

        return coffeeOrders.stream().flatMap(coffeeOrder -> coffeeOrder.getCoffeeList().stream())
                .collect(Collectors.groupingBy(Coffee::getType, Collectors.counting()));
    }

    // átlagosan hány kávét rendelnek egyszerre
    public double getAverageOrder() {
        return coffeeOrders.stream().collect(Collectors.averagingInt(coffeeOrder -> coffeeOrder.getCoffeeList().size()));
    }


    public static void main(String[] args) {

        List<CoffeeOrder> orders = new ArrayList<>();

            Coffee espresso = new Coffee(CoffeeType.ESPRESSO,4.9);
            Coffee machiatto = new Coffee(CoffeeType.MACHIATTO, 5.5);
            Coffee ristretto = new Coffee(CoffeeType.RISTRETTO, 4.9);
            Coffee cappuccino = new Coffee(CoffeeType.CAPPUCCINO, 8.9);
            Coffee latte = new Coffee(CoffeeType.LATTE, 8.9);
            Coffee americano = new Coffee(CoffeeType.AMERICANO, 5.9);
            Coffee mocha = new Coffee(CoffeeType.MOCHA, 6.2);

            LocalDate date1 = LocalDate.of(2018, 5, 3);
            LocalDate date2 = LocalDate.of(2018, 5, 4);
            LocalDate date3 = LocalDate.of(2018, 5, 5);
            LocalDate date4 = LocalDate.of(2018, 5, 6);

            LocalTime time1 = LocalTime.of(9, 10);
            LocalTime time2 = LocalTime.of(9, 19);
            LocalTime time3 = LocalTime.of(9, 37);
            LocalTime time4 = LocalTime.of(10, 3);
            LocalTime time5 = LocalTime.of(11, 20);
            LocalTime time6 = LocalTime.of(11, 58);
            LocalTime time7 = LocalTime.of(12, 29);
            LocalTime time8 = LocalTime.of(14, 1);

            orders.add(new CoffeeOrder(Arrays.asList(espresso, espresso, ristretto), LocalDateTime.of(date1, time3)));
            orders.add(new CoffeeOrder(Arrays.asList(cappuccino), LocalDateTime.of(date2, time1)));
            orders.add(new CoffeeOrder(Arrays.asList(americano, americano), LocalDateTime.of(date1, time4)));
            orders.add(new CoffeeOrder(Arrays.asList(latte, mocha), LocalDateTime.of(date1, time2)));
            orders.add(new CoffeeOrder(Arrays.asList(machiatto, espresso, machiatto), LocalDateTime.of(date2, time2)));
            orders.add(new CoffeeOrder(Arrays.asList(espresso, americano), LocalDateTime.of(date4, time7)));
            orders.add(new CoffeeOrder(Arrays.asList(mocha, latte, cappuccino), LocalDateTime.of(date3, time8)));
            orders.add(new CoffeeOrder(Arrays.asList(ristretto, mocha), LocalDateTime.of(date3, time5)));
            orders.add(new CoffeeOrder(Arrays.asList(latte, espresso), LocalDateTime.of(date1, time6)));
            orders.add(new CoffeeOrder(Arrays.asList(americano, ristretto), LocalDateTime.of(date1, time5)));
            orders.add(new CoffeeOrder(Arrays.asList(espresso), LocalDateTime.of(date1, time4)));
            orders.add(new CoffeeOrder(Arrays.asList(mocha, espresso, cappuccino), LocalDateTime.of(date1, time8)));


        System.out.println(new Cafe(orders).getCountByCoffeeType());
        System.out.println(new Cafe(orders).getAverageOrder());

    }


}
