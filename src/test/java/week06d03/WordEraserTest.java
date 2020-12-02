package week06d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordEraserTest {

    @Test
    public void eraseWordTest () {
        assertEquals("körte barack szilva körte birsalma", new WordEraser().eraseWord("alma körte barack alma szilva körte birsalma", "alma"));
    }

}