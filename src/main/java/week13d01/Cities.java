package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Cities {


    public String getLongestCityName(BufferedReader reader) {

        try {
            skipLine(reader);
            return getMaxLengthCity(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

    }


    private void skipLine(BufferedReader reader) throws IOException {
        reader.readLine();
    }


    private String splitLine(String line) throws IOException {
        String[] lineData = line.split(";");

        if (lineData.length > 1) {
        return lineData[1];
    }
            throw new IOException("wrong line, " + line);
        }



    private String getMaxLengthCity(BufferedReader reader) throws IOException {
        String maxLengthCity = "";
        String line;
        while ((line = reader.readLine()) != null) {
            String city = splitLine(line);
            if (city.length() > maxLengthCity.length()) {
                maxLengthCity = city;
            }
        }
        return maxLengthCity;
    }


}
