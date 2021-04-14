package lambdaprimitives;

import java.util.*;
import java.util.stream.IntStream;

public class SportGadgetStore {

    List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }


    // összesen hány termék van a boltban,

    public int getNumberOfProducts() {
        return products.stream().mapToInt(Product::getPiece).sum();
    }

    // átlagosan mennyibe kerül egy termék. Ha nincs termék, 0-t adjon vissza.
    public double getAveragePrice() {
        OptionalDouble avg =  products.stream().mapToDouble(Product::getPrice).average();
    return avg.isPresent() ? avg.getAsDouble() : 0;

    }

    // adott árnál drágább termékek; Összesen 3 féle termék, amelyekből minimum 1 db, maximum 52 db, összesen 74 db van.
    public String getExpensiveProductStatistics(double minPrice) {
        IntSummaryStatistics stat = products.stream()
                .filter(p -> p.getPrice() > minPrice)
                .mapToInt(Product::getPiece).summaryStatistics();
        StringBuilder sb = new StringBuilder();
        sb.append("Összesen ");
        sb.append(stat.getCount() + " ");
        sb.append("féle termék, amelyekből minimum ");
        sb.append(stat.getMin() + " ");
        sb.append(" db, maximum ");
        sb.append(stat.getMax() + " ");
        sb.append(" db, összesen ");
        sb.append(stat.getSum() + " ");
        sb.append(" db van.");

        return sb.toString();
    }


    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Tennis ball", 2.47, 138));
        products.add(new Product("Tennis racket", 29.9, 23));
        products.add(new Product("Running shoes", 57.0, 16));
        products.add(new Product("Fitness banch", 215.0, 7));
        products.add(new Product("Threadmill", 997.0, 4));
        products.add(new Product("Punching bag", 539.9, 3));
        products.add(new Product("Snowboard", 149.0, 12));
        products.add(new Product("Golf ball", 29.99, 64));
        products.add(new Product("Golf club", 127.99, 19));
        products.add(new Product("Mountain bike", 179.0, 5));

        System.out.println(new SportGadgetStore(products).getAveragePrice());
        System.out.println(new SportGadgetStore(products).getExpensiveProductStatistics(100.0));
    }

}

