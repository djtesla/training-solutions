package week13d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LetterCounterTest {

    @Test
    public void letterCounterTest() {

        LetterCounter lc = new LetterCounter();
        assertEquals(6, lc.letterCounter("aöéJlk,.  dHé!"));

    }

}