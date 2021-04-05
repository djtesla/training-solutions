package vizsgafelkészülés04.week15d05senior;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCounterTest {

    @Test
    void countCharsPerTypeTest() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("names.txt"))) {
            Map<CharType, Integer> charTypesMap = new CharacterCounter().countCharsPerType(reader);
            assertEquals(14, charTypesMap.get(CharType.VOWEL));
            assertEquals(19, charTypesMap.get(CharType.CONSONANT));
            assertEquals(3, charTypesMap.get(CharType.OTHER));
        }


    }
}