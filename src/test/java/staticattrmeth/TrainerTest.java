package staticattrmeth;

import introinheritance.Human;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static staticattrmeth.Trainer.getNumberOfTrainers;

class TrainerTest {

    @Test
    public void testCreae () {
        assertEquals(0, getNumberOfTrainers());
        new Trainer("John Doe");
        assertEquals(1, getNumberOfTrainers());


    }





}