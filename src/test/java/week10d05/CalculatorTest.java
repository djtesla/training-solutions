package week10d05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void calculatorTest () {

        Calculator calculator = new Calculator();

        System.out.println(calculator.findMinSum(new int[] {4,2,9,4,15}));


    }

}