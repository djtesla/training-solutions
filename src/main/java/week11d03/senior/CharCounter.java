package week11d03.senior;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharCounter {


    public int countChars(String...chars) {
        Set<Character> charSetForAllTexts = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            Set<Character> charSetPerText = getCharSetPerText(chars[i]);
            if (i == 0) {
                charSetForAllTexts = charSetPerText;
            } else {
                charSetForAllTexts = charSetForAllTexts.stream()
                        .filter(charSetPerText::contains)
                        .collect(Collectors.toSet());
            }
        }
        return charSetForAllTexts.size();
    }


    private Set<Character> getCharSetPerText(String text) {
        Set<Character> charSetPerText = new HashSet<>();
        for (char c : text.toCharArray()) {
            charSetPerText.add(c);
        }
        return charSetPerText;
    }


    public static void main(String[] args) {
        System.out.println(new CharCounter().countChars("abc", "cba", "ab"));
    }


}


 /*   Készítsünk egy CharCounter osztályt, melyben van egy int countChars(String[] chars) metódus.
        A feladat az, hogy összeszámoljuk azokat a karaktereket asz összes chars-ban lévő String-ből,
        amelyek mindegyik String-ben szerepelnek. Példa: Ha a chars-ban ["abc", "cba", "ab"] szerepel,
        akkor a visszatérési érték 2, mert az a és a b karakter szerepel mindegyik String-ben.*/
