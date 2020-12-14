package gyakorlás;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest {

    @Test
    public void nextTest () {

        System.out.println(TrafficLight.RED_YELLOW.next());
    }

}