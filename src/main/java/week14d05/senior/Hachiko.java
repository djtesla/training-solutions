package week14d05.senior;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Hachiko {

    public int getNumberOfWordInSrtFile(String fileName) {
        try {
            return Files.lines(Path.of(fileName), Charset.forName("windows-1250")).filter(line -> line.contains("kutya"))
                    .peek(System.out::println)
                    .map(line -> findOccurrences(line, "kutya"))
            .peek(System.out::println)
            .collect(Collectors.summingInt(i->i.intValue()));



        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    public int findOccurrences(String line, String focusedWord) {
        int count = 0;
        String[] lineStr = line.split(" ");

        for (String word : lineStr) {
            if (word.toLowerCase().contains(focusedWord)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Hachiko().getNumberOfWordInSrtFile("hachiko.srt"));
    }

}


/*
    Az examples/week14d05/hachiko.srt van a Hachiko film felirata. Csak streamek használatával számold ki,
        hogy hányszor hangzik el a kutya neve a filmben!

        Segítség: a Files.lines() adja vissza a fájl sorait streamben.*/
