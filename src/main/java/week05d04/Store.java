package week05d04;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products = new ArrayList<>();


    public List<Product> getProducts() {
        return products;
    }

    public boolean addProduct(Product productToAdd) {

        if (!isIncluded(productToAdd) && productToAdd.isValid()) {
                products.add(productToAdd);
                return true;
            }
        return false;
    }


    private boolean isIncluded(Product productToAdd) {

        for (Product product : products) {
            if (product.getName().equals(productToAdd.getName())) {
                return true;
            }
        }
        return false;

    }

}

