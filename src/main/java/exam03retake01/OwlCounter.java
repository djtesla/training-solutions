package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    private Map<String, Integer> owlsPerCounty = new HashMap<>();


    public void readFromFile(BufferedReader reader) {
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                putEntry(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }


    private void putEntry(String line) {
        String county = line.split("=")[0];
        String numberOfOwlsStr = line.split("=")[1];
        int numberOfOwls = Integer.parseInt(numberOfOwlsStr);
        owlsPerCounty.put(county, numberOfOwls);
    }


    public int getNumberOfOwls(String county) {
        return owlsPerCounty.get(county);
    }


}
