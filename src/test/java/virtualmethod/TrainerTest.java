package virtualmethod;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    @Test
    public void testFreeTymeByhuman () {

        Human human = new Human("Gézu");
        assertEquals(4, human.getFreeTime());

        Trainer trainer = new Trainer("Gézu", Arrays.asList(new Course("Course1")));
        assertEquals(3, trainer.getFreeTime());

        Human human1 = new Trainer("Gézu", Arrays.asList(new Course("Course1")));
        assertEquals(3, trainer.getFreeTime());


    }

}