package postcoursegyak.eniko;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class CsipkeRose {

    public Map<Character, Integer> createStatOfTale(String filename) {
        Map<Character, Integer> statOfTale = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line, statOfTale);
                skipEmptyRow(reader);
            }
            return statOfTale;
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

    }

    private void processLine(String line, Map<Character, Integer> statOfTale) {
        for (char c : line.toLowerCase().toCharArray()) {
            if (isLetter(c)) {
                modifyMap(statOfTale, c);
            }
        }
    }

    private void modifyMap(Map<Character, Integer> statOfTale, char c) {
        if (!statOfTale.containsKey(c)) {
            statOfTale.put(c, 0);
        }
        statOfTale.put(c, statOfTale.get(c) + 1);
    }

    private boolean isLetter(char c) {
        return (int) c > 96 && (int) c < 123;
    }


    private void skipEmptyRow(BufferedReader reader) throws IOException {
        reader.readLine();
    }


    public static void main(String[] args) {
        System.out.println(new CsipkeRose().createStatOfTale("src\\main\\java\\postcoursegyak\\eniko\\beauty.txt"));
    }
}


  /*  A sleepingbeauty.txt fájlban találod a Csipkerózsika című mesét. A feladat az, hogy készíts belőle statisztikát: melyik betűből
        hány darab található benne. Fontos, hogy csak a betűk számítanak, az egyéb karakterek nem kellenek, valamint hogy a nagy- és
        kisbetűk között ne tégy különbséget! (Tehát az "A" és az "a" egy helyre számolandó.)

        (A fájl az src/main/resources könyvtárban található.)*/
