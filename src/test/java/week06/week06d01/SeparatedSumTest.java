package week06.week06d01;

import org.junit.jupiter.api.Test;
import week06.week06d01.SeparatedSum;

import static org.junit.jupiter.api.Assertions.*;

class SeparatedSumTest {

    SeparatedSum ss = new SeparatedSum();

    @Test
    public void testSumWhenPositive (){
     assertEquals(17.32, ss.sum("1,5;-2,6;5,22;-1,11;10,6")[0]);
    }

    @Test
    public void testSumWhenNegative (){
        assertEquals(-3.71, ss.sum("1,5;-2,6;5,22;-1,11;10,6")[1]);
    }

}