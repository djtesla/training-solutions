package lambdaintermediate;

public class Coffee {

    private CoffeeType type;
    private double price;

    public Coffee(CoffeeType type, double price) {
        this.type = type;
        this.price = price;
    }

    public CoffeeType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "type=" + type +
                ", price=" + price +
                '}';
    }
}
