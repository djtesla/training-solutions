package exam02;

import java.util.ArrayList;
import java.util.List;

public class ArraySelector {

    public String selectEvens (int[] numbers) {

        List<Integer> elementsWithEvenIndex = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0) {
                elementsWithEvenIndex.add(numbers[i]);
            }
        }

        if (elementsWithEvenIndex.size() == 0) {
            return "";
        } else {
            return elementsWithEvenIndex.toString();
        }
    }


}

/*
Tömbök
Írj egy olyan metódust az ArraySelector osztályban, mely egy kapott tömbből minden második elemet kiválogat,
és egy szövegként összerak, szögletes zárójelek között!

A páros megállapítása index szerint működik. Azaz az első, nulla indexű elem páros, a második, azaz egyes indexű
elem páratlan, stb.

Ha nulla elemű a tömb, akkor üres stringet adjon vissza!

CV

Egy önéletrajzot reprezentáló osztályt kell létrehozni, melyben van egy név, valamint skillek (hogy mihez ért az illető).
A skill egy névvel és egy számmal (szint) rendelkezik, utóbbi 1 - 5 között.

Az önéletrajz a Cv osztály pár metódussal, a skill a Skill osztály.

A skillek megadása a nevével, valamint a szintjével történik, pl. programming (5).

A findSkillLevelByName() a skill neve alapján visszaadja annak szintjét.*/
