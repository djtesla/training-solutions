package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Cities {


    public String getLongestCityName(BufferedReader reader) {

        String longest = null;

            String line;

            int mostChars = 0;
            try {
                while ((line = reader.readLine()) != null) {
                    String[] lineData = line.split(";");

                    if (lineData[1].length() > mostChars) {
                        mostChars = lineData[1].length();
                        longest = lineData[1];
                    }
                }

            } catch (IOException ioe) {
                throw new IllegalStateException("Cannot read file", ioe);
            }

            return longest;
    }

}
