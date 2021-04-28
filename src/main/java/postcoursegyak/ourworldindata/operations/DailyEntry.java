package postcoursegyak.ourworldindata.operations;

import java.time.LocalDate;

public class DailyEntry {

    private long id;
    private String continent;
    private String location;
    private LocalDate date;
    private int totalCases;
    private int newCases;
    private int totalDeaths;
    private int newDeaths;
    private int icuPatients;
    private int hospPatients;
    private int peopleVaccinated;
    private int peopleFullyVaccinated;
    private int newVaccinations;
    private int population;

    public DailyEntry(String continent, String location, LocalDate date, int totalCases, int newCases, int totalDeaths, int newDeaths, int icuPatients, int hospPatients, int peopleVaccinated, int peopleFullyVaccinated, int newVaccinations, int population) {
        this.continent = continent;
        this.location = location;
        this.date = date;
        this.totalCases = totalCases;
        this.newCases = newCases;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.icuPatients = icuPatients;
        this.hospPatients = hospPatients;
        this.peopleVaccinated = peopleVaccinated;
        this.peopleFullyVaccinated = peopleFullyVaccinated;
        this.newVaccinations = newVaccinations;
        this.population = population;
    }

    public DailyEntry(String location, LocalDate date, int newCases) {
        this.location = location;
        this.date = date;
        this.newCases = newCases;

    }

    public long getId() {
        return id;
    }

    public String getContinent() {
        return continent;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTotalCases() {
        return totalCases;
    }

    public int getNewCases() {
        return newCases;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public int getIcuPatients() {
        return icuPatients;
    }

    public int getHospPatients() {
        return hospPatients;
    }

    public int getPeopleVaccinated() {
        return peopleVaccinated;
    }

    public int getPeopleFullyVaccinated() {
        return peopleFullyVaccinated;
    }

    public int getNewVaccinations() {
        return newVaccinations;
    }

    public int getPopulation() {
        return population;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return

                ", location='" + location + ", date=" + date + ", newCases=" + newCases;

    }
}
