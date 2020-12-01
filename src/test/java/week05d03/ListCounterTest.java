package week05d03;

import org.junit.jupiter.api.Test;
import week05d03.ListCounter;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ListCounterTest {

    ListCounter listCounter = new ListCounter();


    @Test
    public void testCounter () {
        assertEquals(2, listCounter.counter(Arrays.asList("apa", "baba", "Andorra")));
    }

    @Test
    public void testCounterIfListIsEmpty () {
        assertEquals(0, listCounter.counter(new ArrayList<>()));
    }








}