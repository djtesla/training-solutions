package week09d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibCalculatorTest {

    @Test

    public void testSum () {

        FibCalculator fibCalculator = new FibCalculator();

        System.out.println(fibCalculator.sumEvens(190000));
    }

}