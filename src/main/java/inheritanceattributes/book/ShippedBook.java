package inheritanceattributes.book;

public class ShippedBook extends Book {

    public ShippedBook(String title, int price) {
        super(title, price);
    }

    public int order(int pieces) {

        return 0;
    }


    @Override
    public String toString() {
        return "ShippedBook{" +
                "price=" + price +
                '}';
    }
}
