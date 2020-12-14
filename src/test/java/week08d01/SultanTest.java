package week08d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SultanTest {





    @Test
    public void openDoorsTest () {

        Sultan sultan = new Sultan();

        for (int i = 1; i <= 100; i++) {
            sultan.add(new Door(i));
        }


       List<Integer> openDoors = sultan.openDoors();

        System.out.println(openDoors.size());
        System.out.println(openDoors);





    }

}