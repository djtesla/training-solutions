package week15d04;

import vizsgafelkészülés03.Filekezelés;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoronaStatistics {

    List<CovidCasesPerWeek> stat = new ArrayList<>();

    public List<CovidCasesPerWeek> getStat() {
        return stat;
    }

    public void uploadList(BufferedReader reader) {

        try {
            readHeader(reader);
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(",Hungary,")) {
                    String weekStr = line.split(",")[1];
                    int week = Integer.parseInt(weekStr.split("-")[1]);
                    int cases = Integer.parseInt(line.split(",")[2]);
                    stat.add(new CovidCasesPerWeek(week,cases));
                }
            }
            Collections.sort(stat);

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }


    }
    private void readHeader(BufferedReader br) throws IOException {
        br.readLine();
    }


    public static void main(String[] args) {
        String file = "data.csv";
        try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
            CoronaStatistics cs = new CoronaStatistics();
            cs.uploadList(reader);
            System.out.println(cs.getStat());

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot load file", ioe);
        }
    }

}
