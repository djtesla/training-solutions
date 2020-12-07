package methodstructure.pendrives;

public class Pendrive {

    private String name;
    private int capacity;
    private int price;

    public Pendrive() {
    }

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return
                "name='" + name +
                ", capacity=" + capacity +
                ", price=" + price;
    }

    public void risePrice(int percent) {
        price = price + (int)((price / 100D) * percent);
    }

    public int comparePricePerCapacity(Pendrive pendrive) {
        if (this.ratioOfPriceAndCapacity() > pendrive.ratioOfPriceAndCapacity()) {
            return 1;
        } else if (this.ratioOfPriceAndCapacity() < pendrive.ratioOfPriceAndCapacity()) {
            return -1;
        } else {
            return 0;
        }

    }

    private double ratioOfPriceAndCapacity() {
        return (double) price / capacity;
    }


    public boolean cheaperThan(Pendrive pendrive) {
        return this.price < pendrive.price;
    }
}
