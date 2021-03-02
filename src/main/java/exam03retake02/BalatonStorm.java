package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.*;

public class BalatonStorm {


    public List<String> getStationsInStorm(BufferedReader reader) {
        List<String> stationsInStorm = new ArrayList<>();
        try {
            readIrrelevantRows(reader, 2);
            while ((reader.readLine()) != null) {
                String station = getRelevantStrByLine(reader);
                readIrrelevantRows(reader, 3);
                int level = Integer.parseInt(getRelevantStrByLine(reader));
                if (level == 3) {
                    stationsInStorm.add(station);
                }
                readIrrelevantRows(reader, 3);
                if (isFileEnded(reader)) {
                    return sortByHungarianAlphabet(stationsInStorm);
                }
            }
            return sortByHungarianAlphabet(stationsInStorm);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }



    private List<String> sortByHungarianAlphabet(List<String> stationsInStorm) {
        List<String> sortedList = new ArrayList<>(stationsInStorm);
        Collections.sort(sortedList, Collator.getInstance(new Locale("hu", "HU")));
        System.out.println(sortedList);
        return sortedList;

    }



    private String getRelevantStrByLine(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        return line.split(":")[1]
                .trim()
                .replace(",", "")
                .replace("\"", "");
    }



    private void readIrrelevantRows(BufferedReader reader, int numberOfRows) throws IOException {
        for (int i = 1; i <= numberOfRows; i++) {
            reader.readLine();
        }
    }


    private boolean isFileEnded(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        return line == "]";
    }

}




    /*      "id": 8,
            "allomas": "Balatonaliga",
            "lat": "46.9870754238105",
            "lng": "18.161186597553296",
            "description": "Közforgalmú Club Aliga Rt. kikötő",
            "level": 0,
            "groupId": "BE",
            "stationType": "LED"
*/