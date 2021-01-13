package week11d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordFilterTest {

    WordFilter wf = new WordFilter();

    @Test
    public void wordFilterTest () {

        assertEquals(3, wf.wordsWithChar(List.of("alma","körte", "meggy", "ananász", "eper", "avokádó"), 'a').size());

    }

}