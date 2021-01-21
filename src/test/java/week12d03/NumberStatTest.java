package week12d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberStatTest {

    @Test

    public void getSmallestNumberWithOneOccurrenceTest () {

        //assertThrows(IllegalArgumentException.class, () -> new NumberStat().getSmallestNumberWithOneOccurrence());
        assertEquals(9, new NumberStat().getSmallestNumberWithOneOccurrence());


    }

}