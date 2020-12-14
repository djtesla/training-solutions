package interfaceextends;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    @Test
    public void textCreate () {

        HasName hasName = new Trainer("John Doe", 30);
        HasNameAndAge hasNameAndAge = new Trainer("John Doe", 30);

    }




}