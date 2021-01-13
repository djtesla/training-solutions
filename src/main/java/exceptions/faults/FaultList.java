package exceptions.faults;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FaultList {

    public List<String> processLines(List<String> lines) {

        if (isEmpty(lines)) {
            throw new IllegalArgumentException("lines is null or empty");
        }

        List<String> results = new ArrayList<>();

        ProcessingResult result = ProcessingResult.NO_ERROR;
        int index = 0;


        for (String line : lines) {
            String[] measureData = line.trim().split(",");
            index = readIndex(measureData[0]);

            if (index != -1) {


                if (measureData.length == 3 && isValueValid(measureData[1]) && IsValidDate(measureData[2])) {
                    continue;
                }

                if (measureData.length != 3) {
                    result = ProcessingResult.WORD_COUNT_ERROR;
                }

                if (!isValueValid(measureData[1])) {
                    result = ProcessingResult.VALUE_ERROR;
                }

                if (!IsValidDate(measureData[2])) {
                    result = ProcessingResult.DATE_ERROR;
                }

                if (!IsValidDate(measureData[2]) && !isValueValid(measureData[1])) {
                    result = ProcessingResult.VALUE_AND_DATE_ERROR;
                }

                results.add("" + index + "," + result.getCode());
            }
        }

        return results;
    }


    public int readIndex(String element1) {
        int index = 0;
        try {
            index = Integer.parseInt(element1);
        } catch (NumberFormatException nfe) {
            return -1;
        }
        return index;
    }


    public boolean isValueValid(String element2) {

        try {
            Double.parseDouble(element2);

        } catch (NumberFormatException nfe) {
            return false;

        }
        return true;
    }


    private boolean IsValidDate(String word) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy.MM.dd.");
            df.parse(word);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

        //LocalDate dateOfMeasure = LocalDate.of(year, month, day);



    public boolean isEmpty(List<String> lines) {
        return lines == null || lines.size() == 0;
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
