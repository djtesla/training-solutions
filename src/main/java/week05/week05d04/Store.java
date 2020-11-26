package week05.week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products = new ArrayList<>();


    public void addProduct(Product productToAdd) {

        for (Product product : products) {

            if (!product.getName().equals(productToAdd.getName()) &&
                    !productToAdd.getLocalDate().isBefore(LocalDate.now()));
            products.add((product));
        }
        System.out.println("Lejárt a termék vagy már szerepel a listában!");

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

