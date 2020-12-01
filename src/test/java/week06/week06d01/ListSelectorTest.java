package week06.week06d01;

import org.junit.jupiter.api.Test;
import week06d01.ListSelector;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ListSelectorTest {

    @Test
    public void concatenateEverySecondShouldThrowException() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new ListSelector().concatenateEverySecond(null));
        assertEquals("List doesn't contain any element!", e.getMessage());
    }

    @Test
    public void concatenateEverySecond() {
        assertEquals("[alma,körte]", new ListSelector().concatenateEverySecond(Arrays.asList(
                "alma", "barack", "körte", "szilva")));
    }

    @Test
    public void concatenateEverySecondIfStringIsEmpty() {
        assertEquals("", new ListSelector().concatenateEverySecond(new ArrayList<>()));


    }
}