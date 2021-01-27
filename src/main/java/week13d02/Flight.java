package week13d02;

import java.time.LocalTime;

public class Flight {


    private String flightNumber;
    private FlightInformation flightInformation;
    private String city;
    private LocalTime time;


    public Flight(String flightNumber, FlightInformation flightInformation, String city, LocalTime time) {
        this.flightNumber = flightNumber;
        this.flightInformation = flightInformation;
        this.city = city;
        this.time = time;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public FlightInformation getFlightInformation() {
        return flightInformation;
    }

    public String getCity() {
        return city;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "flightNumber='" + flightNumber + '\'' +
                ", flightInformation=" + flightInformation +
                ", city='" + city + '\'' +
                ", time=" + time;
    }
}
