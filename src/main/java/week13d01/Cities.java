package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Cities {


    public String getLongestCityName(String fileName) {

        String longest = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/" + fileName)))) {

            String line;


            int mostChars = 0;
            while ((line = reader.readLine()) != null) {

                String[] lineData = line.split(";");

                if (lineData[1].length() > mostChars) {
                    mostChars = lineData[1].length();
                    longest = lineData[1];
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file");
        }


        return longest;
    }

}
