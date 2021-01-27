package week13d02;

public class FlightInformationStat {

    private FlightInformation flightInformation;
    private int occurrences;

    public FlightInformationStat(FlightInformation flightInformation, int occurrences) {
        this.flightInformation = flightInformation;
        this.occurrences = occurrences;
    }

    public FlightInformation getFlightInformation() {
        return flightInformation;
    }

    public int getOccurrences() {
        return occurrences;
    }

    @Override
    public String toString() {
        return "flightInformation=" + flightInformation +
                ", occurrences=" + occurrences;

    }
}
