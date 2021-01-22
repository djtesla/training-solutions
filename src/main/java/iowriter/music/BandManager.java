package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {

    private List<Band> bands = new ArrayList<>();

    public List<Band> getBands() {
        return bands;
    }


    public void readBandsFromFile(Path source) {

        try (BufferedReader reader = Files.newBufferedReader(source)) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                bands.add(new Band(data[0], Integer.parseInt(data[1])));
            }

        } catch (NumberFormatException nfe) {
            throw new IllegalStateException("Invalid data in fie; text cannot be parsed to int", nfe);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }



    public void writeBandsBefore(Path target, int year) {

        List<Band> selectedBands = getBandsBeforeYear(year);

        try (BufferedWriter writer = Files.newBufferedWriter(target)) {

            for (Band band : selectedBands) {
                String line = band.getName() + ";" + band.getYear();
                writer.write(line + "\n");
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }


    public List<Band> getBandsBeforeYear(int year) {

        List<Band> selectedBands = new ArrayList<>();

        for (Band band : bands) {
            if (band.getYear() < year) {
                selectedBands.add(band);
            }
        }
        return selectedBands;
    }


}
