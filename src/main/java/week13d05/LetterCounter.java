package week13d05;

import java.sql.Array;
import java.util.*;

public class LetterCounter {

    public int letterCounter(String text) {

        List<Character> abc = new LinkedList<>(Arrays.asList(
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'u', 't','v', 'w', 'x', 'y', 'z'));

        Set<Character> selected = new HashSet<>();
        char[]letters = text.toLowerCase().toCharArray();

        for (char c: letters) {
            if (abc.contains(c)) {
                selected.add(c);
            }
        }
        return selected.size();
    }






}




    /*Írj egy metódust, amely megszámolja, hogy hány különböző betű van
    egy szóban. A kis és nagybetűk közötti különbség nem számít!
    A space-eket, számjegyeket, stb. ne vegye figyelembe! Csak az
    angol ábécé betűit! (edited)*/






