package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Corona {

// map nem lesz jó! ha ugyannnyi két hétre az esetszám,  akkor csak egyszer lesz benne.

    public Map<Integer, Integer> readWithReaderFileUniversal(String file) {

        Map<Integer, Integer> map = new TreeMap<>();
        try (BufferedReader br = Files.newBufferedReader(Path.of(file))) {
            readHeader(br);
            String line;
            while ((line = br.readLine()) != null) {
                String country = line.split(",")[4];
                if (country.equals("Hungary")) {

                    String weekStr = line.split(",")[1];
                    int week = Integer.parseInt(weekStr.split("-")[1]);
                    int cases = Integer.parseInt(line.split(",")[2]);
                    map.put(cases,week);
                }
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

        return map;
    }


    private void readHeader(BufferedReader br) throws IOException {
        br.readLine();
    }


    public static void main(String[] args) {
        System.out.println(new Corona().readWithReaderFileUniversal("data.csv"));

    }
}


/*
    Letölthetőek a koronavírus adatok innen: https://opendata.ecdc.europa.eu/covid19/casedistribution/csv/data.csv
    // Melyik három héten volt Magyarországon a legtöbb esetszám?*/
