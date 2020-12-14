package interfacestaticmethods;

public class Product implements  Valued{

    private String name;

    private double value;


    public Product(String name, double weight) {
        this.name = name;
        this.value = weight;
    }

    @Override
    public double getValue() {
        return value;
    }
}
