package week14d02;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {

    private String regNumber;
    private List<String> products;

    public ShoppingList(String regNumber, List<String> products) {
        this.regNumber = regNumber;
        this.products = products;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public List<String> getProducts() {
        return new ArrayList<>(products);
    }
}
