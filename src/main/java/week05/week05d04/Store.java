package week05.week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products = new ArrayList<>();


    public void addProduct(Product product) {
        products.add((product));
    }

    public int getNumberOfExpired() {
        int i = 0;
        for (Product product : products) {

            if (product.getLocalDate().isBefore(LocalDate.now())) {
                i++;
            }

        }
        return i;
    }
}

