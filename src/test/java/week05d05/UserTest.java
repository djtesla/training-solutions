package week05d05;

import org.junit.jupiter.api.Test;
import week05d05.User;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void testGetFullName () {

        System.out.println(new User("Ernő", "Zámbó", "djtesla@gmail.com").getFullName());

        assertEquals("Ernő Zámbó", new User("Ernő", "Zámbó", "djtesla@gmail.com").getFullName());
    }

    @Test
    public void testEmailAddressShouldThrowException() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new User("Ernő", "Zámbó", "djteslagmail.com"));
        assertEquals("Invalid mail address!", e.getMessage());
        e = assertThrows(IllegalArgumentException.class, () -> new User("Ernő", "Zámbó", "djtesla@gmailcom"));
        assertEquals("Invalid mail address!", e.getMessage());
        e = assertThrows(IllegalArgumentException.class, () -> new User("Ernő", "Zámbó", "@djteslagmail.com"));
        assertEquals("Invalid mail address!", e.getMessage());
        e = assertThrows(IllegalArgumentException.class, () -> new User("Ernő", "Zámbó", ".djtesla@gmailcom"));
        assertEquals("Invalid mail address!", e.getMessage());
        e = assertThrows(IllegalArgumentException.class, () -> new User("Ernő", "Zámbó", "djtesla.gmail@com"));
        assertEquals("Invalid mail address!", e.getMessage());

    }

    @Test
    public void testisValidMailWhenMailIsValid() {
        assertTrue(new User("Ernő", "Zámbó", "djtesla@g.com").isValidMail("djtesla@g.com"));
    }

    @Test
    public void testisValidMailWhenMailIsInValid() {
        assertFalse(new User("Ernő", "Zámbó", "djtesla@g.com").isValidMail("djtesla@.com"));
    }



}