package week06.week06d02;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products;

    public Store(List<Product> products) {
        this.products = products;
    }

    public int getProductByCategoryName(Category category) {
        int i =0;

        for (Product product: products) {

            if (product.getCategory().name().equals(category.name())) {
                i++;
            }
        }
       return i;
    }

}
