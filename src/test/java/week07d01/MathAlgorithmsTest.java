package week07d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {

    @Test
    public void isPrimeTest () {
        assertEquals(false,MathAlgorithms.isPrime(27));
        assertEquals(true,MathAlgorithms.isPrime(37));
    }

}