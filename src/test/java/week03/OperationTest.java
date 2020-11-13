package week03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    public void getValue () {

        Operation operation = new Operation("111+222");

        assertEquals(333, operation.getResult());



    }

}