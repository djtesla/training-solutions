package week10d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HikingTest {

    @Test

    public void testGetPlusElevation () {
        Hiking hiking = new Hiking();

        double result = hiking.getPlusElevation(Arrays.asList(10D,20D,15D,18D));

        System.out.println(result);


    }

}