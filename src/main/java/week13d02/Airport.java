package week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Airport {


    public List<Flight> processFile(String fileName) {
        Path path = Path.of("src/main/java/week13d02").resolve(fileName);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            return getFlightByLine(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }


    private List<Flight> getFlightByLine(BufferedReader reader) throws IOException {
        String line;
        List<Flight> flights = new ArrayList<>();
        int count = 0;
        while ((line = reader.readLine()) != null) {
            count++;
            String[] lineData = line.split(" ");
            String flightNumber = lineData[0];
            FlightInformation flightInformation = getFlightInformation(lineData[1].toUpperCase(), count);
            String city = lineData[2];
            LocalTime time = getTime(lineData[3]);
            flights.add(new Flight(flightNumber, flightInformation, city, time));
        }
        return flights;
    }


    private LocalTime getTime(String timeStr) {
        String timeData[] = timeStr.split(":");
        return LocalTime.of(Integer.parseInt(timeData[0]), Integer.parseInt(timeData[1]));
    }


    private FlightInformation getFlightInformation(String flightInformationStr, int count) throws IOException {
        for (FlightInformation flightInformation : FlightInformation.values()) {
            if (flightInformation.name().equals(flightInformationStr)) {
                return flightInformation;
            }
        }
        throw new IOException("Flight information is not valid in line " + count);
    }


    private List<FlightInformationStat> getFlightInformationStat(List<Flight> flights) {
        List<FlightInformationStat> statistics = new ArrayList<>();
        int count = 0;
        for (FlightInformation flightInformation : FlightInformation.values()) {
            for (Flight flight : flights) {
                if (flight.getFlightInformation() == flightInformation) {
                    count++;
                }
                statistics.add(new FlightInformationStat(flightInformation, count));
            }
        }
        return statistics;
    }


    public FlightInformationStat getFlightInformationWithMostOccurrence(List<Flight> flights) {
        List<FlightInformationStat> statistics = getFlightInformationStat(flights);
        FlightInformationStat most = statistics.get(0);
        for (FlightInformationStat flightInformationStat : statistics) {
            if (flightInformationStat.getOccurrences() > most.getOccurrences()) {
                most = flightInformationStat;
            }
        }
        return most;
    }


    public Flight getFlightByFlightNumber(List<Flight> flights, String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        throw new IllegalArgumentException("Invalid flight number");
    }



    public List<Flight> getFlightListByCityAndFlightInformation(List<Flight> flights, FlightInformation flightInformation, String city) {
        List<Flight> flightsWithSameCityAndFlightInformation = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getFlightInformation() == flightInformation && flight.getCity().equals(city)) {
                flightsWithSameCityAndFlightInformation.add(flight);
            }
        }
        return flightsWithSameCityAndFlightInformation;
    }



    public Flight getFlightWithEarliestDeparture (List<Flight> flights) {
        Flight earliest = getFirstFlightWithFlightInformation(flights, FlightInformation.DEPARTURE);
        for (Flight flight : flights) {
            if (flight.getFlightInformation() == FlightInformation.DEPARTURE) {
                if (flight.getTime().isBefore(earliest.getTime())) {
                    earliest = flight;
                }
            }
        }
        return earliest;
    }



    private Flight getFirstFlightWithFlightInformation (List<Flight> flights, FlightInformation flightInformation) {
        for (Flight flight : flights) {
            if (flight.getFlightInformation() == flightInformation) {
                return flight;
            }
        }
        throw new IllegalArgumentException("No flight exists with given Flight information");
    }




}







   /* Adott egy fájl melyben egy reptér egy napi munkáját rögzítettük. Adott egy járatszám, az, hogy érkező vagy
   felszálló gépről van-e szó. A kiinduló/cél város, attól függöen hogy indul vagy érkezik-e a gép és a felszállás
   /leszállás pontos ideje.
        ​
        A fájl:
        FC5354 Arrival Dublin 18:16
        KH2442 Departure Berlin 15:54
        ID4963 Departure Amsterdam 15:22
        CX8486 Arrival Brussels 10:37
        EJ9251 Departure  Toronto 11:30
        KJ7245 Departure Bern 6:18
        JN6048 Arrival Moscow 18:39
        MN5047 Arrival Athens 9:35
        ​
        Az időpontok szándékosan így szereplnek, nincsenek nullák a számok előtt. Az adatok össze vissza szerepelnek
         a fájlban.
        Feladatok:
        1. Olvasd be a fájl tartalmát a memóriába.
        2. Határozd meg, hogy induló vagy érkező járatból volt-e több.
        3. Legyen egy metódus ami járatszám alapján ad vissza egy repülőt.
        4. Írj egy metódust ami bekér egy várost és azt, hogy az induló vagy érkező járatokat szeretnénk-e. És egy
         Listába adjuk viassza az összes abba városba induló/érkező repülőt.
        5. Adjuk vissza a legkorábban induló repülőt!

*/