package week10d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MaxTravelTest {

    @Test
    public void testgetMaxIndex () {

        MaxTravel maxTravel = new MaxTravel();
        System.out.println(maxTravel.getMaxIndex(Arrays.asList(1,8,1,2,3,4,6,7,8,5,8,9,2,3,3,11,12,8,8)));
    }

}