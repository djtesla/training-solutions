package week06d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Budget {

    private List<Item> items;

    public Budget(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }


    public List<Item> getItemsByMonth(int month) {

        List<Item> filteredList = new ArrayList<>();


        for (Item item : items) {

            if (item.getDate().getMonthValue() == month) {
                filteredList.add(item);
            }
            }
        return filteredList;
    }
}



/*Junior/Mid level csoport mai gyakorlati feladata:
        Készíts az week06d04 csomagban egy Budget osztályt, amely a konstruktorában
        Item példányokat vár listában (List). Az Item tartalmazza az alábbi attribútumokat:
        int price, int month, String name. A Budget osztály tárolja el egy attribútumban a
        konstruktorban megkapott items listát. Írjunk egy metódust, getItemsByMonth néven, mely
        egy hónapot vár (1-12) és visszaadja az Itemeket az adott hónapban! Bónusz feladat: ellenőrizzük
        a bemeneti paramétereket és írjunk tesztet! (edited) */
