package gyakorlás;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainerBuilderTest {

    @Test
    public void trainerBuilderTest() {
        Trainer trainer = new TrainerBuilder()
                .withName("John Doe")
                .withAge(40)
                .build();

        assertEquals("John Doe", trainer.getName());

    }

}