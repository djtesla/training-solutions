package exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class Histogram {
    public String createHistogram(BufferedReader reader) {
        StringBuilder stars = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                int numberOfStarsPerLine = Integer.parseInt(line);
                stars.append("*".repeat(numberOfStarsPerLine));
                stars.append('\n');
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        return stars.toString();
    }
}


/*    Olvass be egy szöveges fájlt soronként, melyben soronkont számok vannak.
        Majd hozz létre egy stringet, mely ugyanennyi sort tartalmaz, és annyi csillagot ír
        ki egymás mellé soronkont, amennyi a bemeneti fájlban lévő szám.*/
