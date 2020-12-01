package week06d02;

import org.junit.jupiter.api.Test;
import week06d02.Category;
import week06d02.Product;
import week06d02.Store;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    Store store = new Store(Arrays.asList(new Product("kenyér", Category.BAKEDGOODS, 590),
            new Product("túró",Category.DAIRY, 390),
            new Product("mirelit borsó",Category.FROZEN, 490),
    new Product("kalács",Category.BAKEDGOODS, 790)));

    @Test
    public void testGetProductByCategoryName () {
        assertEquals(2, store.getProductByCategoryName(Category.BAKEDGOODS));
    }

}

