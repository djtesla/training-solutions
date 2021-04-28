package postcoursegyak.eniko;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UpperCaseLetters {

    public int getNumberOfUpperCase(String filename) {
        int count = 0;
        try(BufferedReader reader = Files.newBufferedReader(Path.of(filename))) {
            String line;
            while ((line = reader.readLine())!= null) {
                int uppersPerLine = getUppersPerLine(line);
                count += uppersPerLine;
            }
            return  count;
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);

        }
    }

    private int getUppersPerLine(String line) {
        int count = 0;
        for (char c : line.toCharArray()) {
            if (isUpper(c)) {
                count++;
            }
        }
        return count;
    }

    private boolean isUpper(char c) {
        int ascii =  c;
         return ascii > 64 && ascii < 91;
    }


    public static void main(String[] args) {
        System.out.println(new UpperCaseLetters().getNumberOfUpperCase("src\\main\\java\\postcoursegyak\\eniko\\chars.txt"));
    }


}


/*
    Az UpperCaseLetters osztályban a characters.txt fájl felhasználásával írd meg a getNumberOfUpperCase(String filename)
metódust, ami visszaadja a fájlban található mindenféle karakterek közül a nagybetűk számát!
        (A characters.txt az src/main/resources könyvtárban található.)*/
