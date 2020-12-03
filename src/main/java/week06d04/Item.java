package week06d04;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Item {

    private int price;
    private LocalDate date;
    private String name;
    private int month;

    public Item(int price, int year, int month, int day) {

        this.date = LocalDate.of(year, month, day);
        this.price = price;
        this.name = name;
        this.month = month;

    }

    public int getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}

/*Junior/Mid level csoport mai gyakorlati feladata:
        Készíts az week06d04 csomagban egy Budget osztályt, amely a konstruktorában
        Item példányokat vár listában (List). Az Item tartalmazza az alábbi attribútumokat:
        int price, int month, String name. A Budget osztály tárolja el egy attribútumban a
        konstruktorban megkapott items listát. Írjunk egy metódust, getItemsByMonth néven, mely
        egy hónapot vár (1-12) és visszaadja az Itemeket az adott hónapban! Bónusz feladat: ellenőrizzük
        a bemeneti paramétereket és írjunk tesztet! (edited) */
