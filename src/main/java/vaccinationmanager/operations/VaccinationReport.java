package vaccinationmanager.operations;

public class VaccinationReport {

    private String postalCode;
    private int numberOfVaccinations;
    private long numberOfCitizens;

    public VaccinationReport(String postalCode, int numberOfVaccinations, long numberOfCitizens) {
        this.postalCode = postalCode;
        this.numberOfVaccinations = numberOfVaccinations;
        this.numberOfCitizens = numberOfCitizens;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getNumberOfVaccinations() {
        return numberOfVaccinations;
    }

    public long getNumberOfCitizens() {
        return numberOfCitizens;
    }

    @Override
    public String toString() {
        return "postalCode='" + postalCode + '\'' +
                ", numberOfVaccinations=" + numberOfVaccinations +
                ", numberOfCitizens=" + numberOfCitizens +
                '}';
    }
}
