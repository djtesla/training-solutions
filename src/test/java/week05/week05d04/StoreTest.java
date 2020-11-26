package week05.week05d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {


    @Test
    public void StoreTestLocalDates () {

        Store store = new Store();
        store.addProduct(new Product("kenyér", 2020, 11, 25));
        store.addProduct(new Product("kalács", 2020, 11, 20));
        store.addProduct(new Product("kifli", 2020, 11, 27));
        store.addProduct(new Product("zsömle", 2020, 11, 2));

        assertEquals(3, store.getNumberOfExpired());
    }



}