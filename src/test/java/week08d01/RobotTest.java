package week08d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    Robot robot = new Robot();

    @Test
    public void moveTest() {
        assertEquals(5, robot.move("JBJBFLFLlbbjFFFF").getY());

        assertEquals(0, robot.move("llLlL").getX());
    }

    @Test
    public void moveThrowExceptionTest() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> robot.move("JBJBFLFLXbbjFFFF").toString());
        assertEquals("Unknown key", e.getMessage());
    }


}