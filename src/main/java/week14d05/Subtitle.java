package week14d05;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Subtitle {


    public Map<String, Integer> countWords(Reader reader, String... words) throws IOException {

        List<String> lines = readFromFile(reader);
        return createWordsCountMap(lines, words);
    }


    private Map<String, Integer> createWordsCountMap(List<String> lines, String[] words) {
        Map<String, Integer> wordsCountMap = new TreeMap<>();
        for (String word : words) {
            int numOfOccurrences = getNumOfOccurrences(word, lines);
            wordsCountMap.put(word, numOfOccurrences);
        }
        return wordsCountMap;
    }


    private int getNumOfOccurrences(String word, List<String> lines) {
        int counter = 0;
        for (String line : lines) {
            if (line.toLowerCase().contains(word.toLowerCase())) {
                counter++;
            }
        }
        return counter;
    }


    private List<String> readFromFile(Reader reader) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }
}



/*
    A examples/week14d05/hachiko.srt van a Hachiko film felirata. Írj egy
        countWords() metódust, mely paraméterül várja a fájlt, varargsban
        szavakat. Megszámolja, hogy melyik szó hány sorban szerepel a
        szövegben. Legyenek mondjuk a beadott szavak: "Hachiko", "haza",
        "pályaudvar", "jó"
*/
