package objectclass;

import java.util.Objects;

public class Beer {

    private String name;
    private int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return price == beer.price &&
                Objects.equals(name, beer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Beer{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
