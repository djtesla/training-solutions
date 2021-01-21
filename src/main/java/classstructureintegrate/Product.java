package classstructureintegrate;

public class Product {
    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    public void increasePrice(int amount) {
        price = price + amount;
    }

    public void decreasePrice(int amount) {
        price = price - amount;
    }
}
