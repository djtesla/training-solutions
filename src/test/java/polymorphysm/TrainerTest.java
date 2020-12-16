package polymorphysm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    @Test
    public void testCreate() {
        Trainer trainer = new Trainer("John Doe", Arrays.asList(new Course("Course1")));

        assertTrue(trainer instanceof Trainer);
        assertTrue(trainer instanceof Human);
        assertTrue(trainer instanceof HasName);
        assertTrue(trainer instanceof Object);

        Object object = new Trainer("John Doe", Arrays.asList(new Course("Course1")));

        assertTrue(object instanceof Trainer);
        assertTrue(object instanceof Human);
        assertTrue(object instanceof HasName);
        assertTrue(object instanceof Object);


    }


    @Test
    public void testConvert() {

        Trainer trainer = new Trainer("John Doe", Arrays.asList(new Course("Course1")));

        //Human human = trainer;
        HasName hasName = trainer;

        Human human = new Trainer("John Doe", Arrays.asList(new Course("Course1")));
        Trainer trainer1 = (Trainer)human;

        //won't work
        Human human2 = new Human("Géza");

        Trainer trainer2 = (Trainer)human2;



    }
}