package week05.week05d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCounter {

    public int counter (List<String> words) {

        if (words.size() == 0) {
            return 0;
        }

        int i = 0;
        for (String word: words) {
            if (word.toLowerCase().startsWith("a")) {
                i++;

            }
        }
        return i;
    }


    public static void main(String[] args) {
        ListCounter listCounter = new ListCounter();

        System.out.println(listCounter.counter(Arrays.asList("pa","mama", "papa", "ndorra")));
        System.out.println(listCounter.counter(new ArrayList<>()));
    }
}


  /*  Junior és Mid-Level csoport mai feladata:
        Írj egy olyan metódust az week05d03.ListCounter osztályban, mely egy kapott Listából (String)
        összeszámolja azokat amik 'a' vagy 'A' betűvel kezdődnek,
        Ha nulla elemű a tömb,vagy nincs benne ilyen elem, akkor 0-t adjon vissza*/