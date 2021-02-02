package week14d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OnlineShopTest {

    @Test
    public void testGetNumberOfProductPerName() {

        OnlineShop onlineShop = new OnlineShop();
        onlineShop.uploadShoppingLists();

        System.out.println(onlineShop.getNumberOfProductPerName("sugar"));
    }

    @Test
    public void testTypesPerReg() {

        OnlineShop onlineShop = new OnlineShop();
        onlineShop.uploadShoppingLists();

        System.out.println(onlineShop.getNumberOfProductTypesPerRegNumber("C123"));
    }


     @Test
    public void testStatistics() {

         OnlineShop onlineShop = new OnlineShop();
         onlineShop.uploadShoppingLists();

         System.out.println(onlineShop.getStatistics());
     }

}

