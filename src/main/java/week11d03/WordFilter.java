package week11d03;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {

    public List<String> wordsWithChar(List<String> words, char c) {


        List<String> wordsWithChar = new ArrayList<>();

        for (String word : words) {

            String charStr = Character.toString(c);

            if (word.contains(charStr)) {
                wordsWithChar.add(word);
            }
        }

        return wordsWithChar;
    }
}

/*    Készíts egy WordFilter osztályt, melyben van egy List<String> wordsWithChar(List<String> words, char c) metódus.
        A metódus kiválógatja a paraméterül kapott String listából azokat a szavakat, melyekben előfordul a c karakter,
        majd ezeket visszaadja egy listában*/
