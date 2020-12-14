package week07d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LabTest {

    @Test
    public void createTest() {
        assertFalse(new Lab("inheritance").isCompleted());

        assertTrue(new Lab("inheritance", 2020, 12, 10).isCompleted());

        assertTrue(new Lab("inheritance").complete(2020,12,15).isCompleted());



    }

    @Test
    public void completeTest() {


    }

}