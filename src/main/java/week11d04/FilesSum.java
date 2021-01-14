package week11d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {


    public int sumNumbers() {

        int sum = 0;

        for (int i = 0; i < 100; i++) {
            String fileName = getFileName(i);

            if (Files.isRegularFile(Path.of(fileName))) {
                int content = readFromFile(fileName);
                sum += content;
            }
        }
        return sum;
    }



    public String getFileName (int i) {

        String fileName = "";

        if (i < 10) {
            fileName = "0" + i;
        } else {
            fileName = Integer.toString(i);
        }

        return fileName;
    }



    public int readFromFile(String fileName) {
        int content = 0;
        try {
            content = Integer.parseInt(Files.readString(Path.of(fileName)));

        } catch (IOException e) {
            throw new IllegalArgumentException("", e);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("", nfe);
        }

        return content;
    }

}


/*    Adott az aktuális könyvtárban több, fájl, melynek a nevei: number00.txt, number03.txt, number20.txt, egészen 99-ig.
        Nem minden fájl létezik, lehet, hogy bizonyos számhoz tartozó fájl kimaradt. Olvasd be az állományból a benne lévő
        számot, és ezt összegezd! Használd a Files.isRegularFile() metódust arra, hogy megnézd, létezik-e a fájl!
        Használd a Files.readString() metódust a fájl beolvasására! A FilesSum osztály sumNumbers(InputStream) metódusába dolgozz!*/
