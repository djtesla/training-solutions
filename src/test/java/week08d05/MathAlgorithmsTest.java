package week08d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {


    @Test
    public void greatestCommonDivisorTest () {

        MathAlgorithms mathAlgorithms = new MathAlgorithms();

        assertEquals(4, mathAlgorithms.greatestCommonDivisor(4, 12));
        assertEquals(11, mathAlgorithms.greatestCommonDivisor(33, 44));
        assertEquals(1, mathAlgorithms.greatestCommonDivisor(13, 25));


    }

}