package week06d02;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products;

    public Store(List<Product> products) {
        this.products = products;
    }


    public CategoryCounter getProductByCategoryName(Category category) {
        int i =0;

        for (Product product: products) {

            if (product.getCategory().name() == category.name()) {
                i++;
            }
        }
       return new CategoryCounter(category,i);
    }

}
