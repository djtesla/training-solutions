package week10d02;

import java.util.List;

public class MaxTravel {


    public int getMaxIndex(List<Integer> numbers) {

        int[] stations = new int[30];

        for (int number : numbers) {
            stations[number] += 1;
        }

        int max = 0;

        for (int i = 0; i < stations.length; i++) {

            if (stations[i] > max) {
                max = i;
            }

        }
        return max;
    }
}

   /* Van egy egész számok listája, amelyben egy szám azt jelzi, hogy az adott számú buszmegállóban egy ember fel akar szállni.
        A 12,12,0,3,4,4 sorozat tehát azt jelenti, hogy a 12-es buszmegállóban 2-en, a 0-ásban 1 ember, 3-asban egy ember, 4-esben 2 ember
        akar felszállni. A MaxTravel osztály getMaxIndex() metódusa adja vissza, hogy hanyas megállóban szeretnének a legtöbben felszállni.
        Maximum 30 megálló lehet.*/
