package week05d04;

import org.junit.jupiter.api.Test;
import week05d04.Currency;
import week05d04.ProductSenior;

import static org.junit.jupiter.api.Assertions.*;

class ProductSeniorTest {

    @Test
    public void testIllegalArgumentExceptionIfPriceIsNegative () {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new ProductSenior(-200, Currency.USD).convertPrice(Currency.USD));
        assertEquals("invalid price or no currency!", e.getMessage());
    }

    @Test
    public void testIllegalArgumentExceptionIfCurrencyIsNull () {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new ProductSenior(200,null).convertPrice(Currency.USD));
        assertEquals("invalid price or no currency!", e.getMessage());
        e = assertThrows(IllegalArgumentException.class, () -> new ProductSenior(200,Currency.HUF).convertPrice(null));
        assertEquals("invalid price or no currency!", e.getMessage());
    }


    @Test
    public void testConvertPriceHUFUSD () {
        assertEquals(0.5, new ProductSenior(150,Currency.HUF).convertPrice(Currency.USD));
    }

    @Test
    public void testConvertPriceUSDHUF () {
        assertEquals(60000.0, new ProductSenior(200,Currency.USD).convertPrice(Currency.HUF));
    }

    @Test
    public void testConvertPriceHUFHUF () {
        assertEquals(150.0, new ProductSenior(150,Currency.HUF).convertPrice(Currency.HUF));
    }

    @Test
    public void testConvertPriceUSDUSD () {
        assertEquals(200.0, new ProductSenior(200,Currency.USD).convertPrice(Currency.USD));

    }

}
