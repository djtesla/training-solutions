package ioreaderclasspath.countries;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {


    private List<Country> countryList = new ArrayList<>();


    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }

    public void readFromFile(String filename) {


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CountryStatistics.class.getResourceAsStream("/" + filename)))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineData = line.split(" ");
                countryList.add(new Country(lineData[0], Integer.parseInt(lineData[1])));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);

        } catch (NumberFormatException nfe) {
        throw new IllegalStateException("Invalid data in file", nfe);
    }




}



    public int numberOFCountries() {
        return countryList.size();
    }


    public Country mostBorderCountries() {

        Country countryWithMostNeighbours = countryList.get(0);

        for (int i = 1; i <countryList.size(); i++) {

            Country countryInFocus = countryList.get(i);

            if (countryInFocus.getBorderCountries() > countryWithMostNeighbours.getBorderCountries()) {
                countryWithMostNeighbours = countryInFocus;
            }
        }
        return countryWithMostNeighbours;
    }
}
