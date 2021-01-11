package exceptions.faults;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FaultList {

    public List<String> processLines(List<String> lines) {


        Scanner scanner = null;
        Scanner scanner2 = null;

        for (String line : lines) {
            scanner = new Scanner(line.trim()).useDelimiter(",");

            while (scanner.hasNext()) {

                int rank = Integer.parseInt(scanner.next());
                double measure = Double.parseDouble(scanner.next());

                String dateString = scanner.next();

                scanner2 = new Scanner(dateString.trim()).useDelimiter(".");
                System.out.println(dateString);

                int year = Integer.parseInt(scanner2.next());
                int month = Integer.parseInt(scanner2.next());
                int day = Integer.parseInt(scanner2.next());

                LocalDate date = LocalDate.of(year, month, day);


            }

        }


        return null;
    }

}


   /* Bemeneti adatok ellenőrzése példa
    Egy felhasználóktól nyert adatokat kell feldolgozni és a hibás sorokról jelentést készíteni.
        A bemeneti adatok sorai tartalmazhatnak megjegyzésbe tett sorokat is, tehát lehet benne adatsor és lehet megjegyzés sor.

        Az adatsorok szerkezete: sorszám, mértérték, mérésdátum. Pl. 12, 34.5, 2014.05.22. A megjegyzésbe tett sorok ugyanúgy ,
        karakterrel elválasztott három részből állnak, csak az első rész nem alakítható számmá. Pl. M12, 12, 2014.01.01. A hiba
        jelentés tartalmazzon bejegyzést minden olyan sorról, amely nem megjegyzésbe tett és hiba van benne. A jelentés egy List<String>
legyen, ahol a String tartalmazza a hibás sor sorszámát és a hiba kódját, sorszam, hibakód alakban. Figyelem, a hibaüzenetben a sorban
        szereplő sorszámot kell kiírni, és nem azt a számot (indexet), amelyik pozíción szerepel az adott sor.

        Hibakódok:

        2: WORDCOUNT_ERROR, azaz a sor nem bontható 3 db , karakterrel elválaszható részre.
        4: VALUE_ERROR, azaz a második rész nem double szám.
        8: DATE_ERROR, azaz a harmadik rész nem yyyy.MM.dd. alakú dátum
        12: VALUE_AND_DATE_ERROR: azaz egyszerre van VALUE_ERROR és DATE_ERROR is.
        Megoldáshoz további részletek
        Készíts egy FaultList osztályt, amelynek van egy public List<String> processLines(List<String> lines) metódusa
        A hibakódokhoz célszerű egy enumot definiálni
        Egy sor feldolgozására célszerű egy private metódust készíteni, ami visszaadja a sor feldolgozás eredményét (az eredmény
        vagy a hibakódok valamelyike vagy NO_ERROR vagy COMMENT)
        [rating feedback=java-ex*/
