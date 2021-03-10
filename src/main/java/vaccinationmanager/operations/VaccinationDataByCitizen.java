package vaccinationmanager.operations;

import java.time.LocalDateTime;

public class VaccinationDataByCitizen {

    private long id;
    private int numberOfVaccinations;
    private LocalDateTime lastVaccination;
    private String vaccinationsType;

    public VaccinationDataByCitizen(long id, int numberOfVaccinations, LocalDateTime lastVaccination, String vaccinationsType) {
        this.id = id;
        this.numberOfVaccinations = numberOfVaccinations;
        this.lastVaccination = lastVaccination;
        this.vaccinationsType = vaccinationsType;
    }

    public VaccinationDataByCitizen(long id, int numberOfVaccinations, LocalDateTime lastVaccination) {
        this.id = id;
        this.numberOfVaccinations = numberOfVaccinations;
        this.lastVaccination = lastVaccination;
    }

    public long getId() {
        return id;
    }

    public int getNumberOfVaccinations() {
        return numberOfVaccinations;
    }

    public LocalDateTime getLastVaccination() {
        return lastVaccination;
    }

    public String getVaccinationsType() {
        return vaccinationsType;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", numberOfVaccinations=" + numberOfVaccinations +
                        ", lastVaccination=" + lastVaccination +
                        ", vaccinationsType='" + vaccinationsType;

    }
}
