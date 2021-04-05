package vizsgafelkészülés04.week15d05senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CharacterCounter {

    public static final List<Character> VOWELS = new ArrayList<>(Arrays.asList('a', 'á', 'e', 'é', 'i', 'í', 'o', 'ó', 'ö', 'ő', 'u', 'ú', 'ü', 'ű'));
    public static final List<Character> CONSONANTS = new ArrayList<>(Arrays.asList('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'));

    public Map<CharType, Integer> countCharsPerType(BufferedReader reader) {

        Map<CharType, Integer> charTypesMap = new HashMap<>();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                processLine(line.toLowerCase(), charTypesMap);
            }
            return charTypesMap;
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void processLine(String line, Map<CharType, Integer> charTypesMap) {
        CharType charType;
        for (char c : line.toCharArray()) {
            if (c != ' ') {
                if (VOWELS.contains(c)) {
                    charType = CharType.VOWEL;
                } else if (CONSONANTS.contains(c)) {
                    charType = CharType.CONSONANT;
                } else {
                    charType = CharType.OTHER;
                }
                putNewMapEntry(charType, charTypesMap);
            }
        }
    }


    private void putNewMapEntry(CharType charType, Map<CharType, Integer> charTypesMap) {
        if (!charTypesMap.containsKey(charType)) {
            charTypesMap.put(charType, 0);
        }
        charTypesMap.put(charType, charTypesMap.get(charType) + 1);
    }


    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("names.txt"))) {
            System.out.println(new CharacterCounter().countCharsPerType(reader));
        }
    }
}
