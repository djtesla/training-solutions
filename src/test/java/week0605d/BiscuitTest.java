package week0605d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BiscuitTest {

    @Test
    public void testOf () {
        assertEquals(BiscuitType.HAJÓS, Biscuit.of(BiscuitType.HAJÓS, 80).getType());
    }

    @Test
    public void testToString () {
        assertEquals("type=HAJÓS, gramAmount=80", Biscuit.of(BiscuitType.HAJÓS, 80).toString());

    }



}