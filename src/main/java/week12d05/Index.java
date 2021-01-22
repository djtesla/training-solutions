package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Index {


    public int getNumberOfWords() {

        int sum = 0;
        String word = "koronavírus";


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Index.class.getResourceAsStream("/index.html")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(word)) {
                    sum+=1;
                }
            }
        } catch (IOException | NullPointerException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

        return sum;

    }
}


/*    Mai junior/mid feladat:
        Töltsd le az index.hu nyitólapját böngészőből, ez egy html állomány! Másold be a projektedbe
        (index.html) néven! Ez egy szöveges állomány. Olvasd be, és számold meg, hány sorban szerepel a
        koronavírus szó! (edited) */
