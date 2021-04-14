package lambdaintermediate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Cafe {

    private List<CoffeeOrder> coffeeOrders;

    public Cafe(List<CoffeeOrder> coffeeOrders) {
        this.coffeeOrders = coffeeOrders;
    }

    public void addCoffeeOrder(CoffeeOrder coffeeOrder) {
        coffeeOrders.add(coffeeOrder);
    }


    // az eddigi összes bevétel
    public double getTotalIncome() {
        return coffeeOrders.stream()
                .flatMap(order -> order.getCoffeeList().stream()).
                        map(Coffee::getPrice)
                .reduce((sum, p) -> sum + p).get();
    }


    // adott napi teljes bevétel
    public double getTotalIncome(LocalDate date) {
        return coffeeOrders.stream().filter(coffeeOrder -> coffeeOrder.getDateTime().toLocalDate().equals(date))
                .flatMap(l -> l.getCoffeeList().stream()).map(Coffee::getPrice).reduce((sum, p) -> sum + p).get();
    }


    // az adott típusú kávéból eladott összmennyiség
    public long getNumberOfCoffee(CoffeeType type) {
        return coffeeOrders.stream()
                .flatMap(l -> l.getCoffeeList().stream())
                .map(Coffee::getType)
                .filter(t -> t == type).count();


    }


    // a megadott időpont utáni rendelések listája
    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from) {
        return coffeeOrders.stream().filter(o -> o.getDateTime().isAfter(from))
                .collect(Collectors.toList());
    }


    // adott napon az első 5 vásárlásban lévő kávék listája
    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) {
        return coffeeOrders.stream().filter(coffeeOrder -> coffeeOrder.getDateTime().toLocalDate().equals(date))
                .sorted(Comparator.comparing(CoffeeOrder::getDateTime))
        .collect(Collectors.toList());

    }

    public List<CoffeeOrder> getCoffeeOrders() {
        return coffeeOrders;
    }


    public static void main(String[] args) {
        List<CoffeeOrder> orders = new ArrayList<>();       
        
            Coffee espresso = new Coffee(CoffeeType.ESPRESSO, 4.9);
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


        System.out.println(new Cafe(orders).getTotalIncome());
        System.out.println(new Cafe(orders).getTotalIncome(LocalDate.of(2018, 5, 4)));
        System.out.println(new Cafe(orders).getNumberOfCoffee(CoffeeType.ESPRESSO));
        System.out.println(new Cafe(orders).getFirstFiveOrder(LocalDate.of(2018, 5, 3)));



    }

    
}
