package week13d02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    Airport airport = new Airport();
    List<Flight> flights = airport.processFile("cities.txt");


    @Test
    public void processFileTest() {

        System.out.println(airport.getFlightInformationWithMostOccurrence(flights));

        System.out.println(airport.getFlightByFlightNumber(flights, "WH4925"));

        System.out.println(airport.getFlightListByCityAndFlightInformation(flights, FlightInformation.ARRIVAL, "Dublin"));

        System.out.println(airport.getFlightWithEarliestDeparture(flights));

    }

}