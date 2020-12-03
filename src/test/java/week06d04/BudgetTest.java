package week06d04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {

    Budget budget = new Budget(Arrays.asList(new Item(1000, 2020, 11, 1),
    new Item(1000, 2020, 11, 1),
    new Item(1000, 2020, 12, 1),
    new Item(1000, 2020, 11, 1)));

    @Test
    public void testgetItemsByMonth () {
        assertEquals(1, budget.getItemsByMonth(12).size());

    }




}