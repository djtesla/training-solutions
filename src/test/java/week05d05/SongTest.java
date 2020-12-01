package week05d05;

import org.junit.jupiter.api.Test;
import week05d05.Song;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    @Test
    public void emptyNameShouldThrowException () {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Song("", 210, "Kft"));
        assertEquals("name or artist is empty!", e.getMessage());
    }

    @Test
    public void emptyArtistShouldThrowException () {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Song("Afrika", 210, ""));
        assertEquals("name or artist is empty!", e.getMessage());
    }

    @Test
    public void nullNameShouldThrowException () {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Song(null, 210, "Kft"));
        assertEquals("name or artist is empty!", e.getMessage());
    }

    @Test
    public void nullArtistShouldThrowException () {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Song("Afrika", 210, null));
        assertEquals("name or artist is empty!", e.getMessage());
    }

    @Test
    public void negativeLengthShouldThrowException () {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Song("Afrika", -10, "Kft"));
        assertEquals("length must be greater than 0!", e.getMessage());
    }

    @Test
    public void testTetLengthInMins () {
        assertEquals(3.5, new Song("Afrika", 210, "Kft").getLengthInMins());
    }

}