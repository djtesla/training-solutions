package vaccinationmanager.operations;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;

public class Citizen {


    //private long id;
    private String name;
    private String postalCode;
    private int age;
    private String email;
    private String socSecNumber;
    private int numberOfVaccinations;
    private LocalDateTime lastVaccination;
    private LocalTime scheduledVaccination;

    public Citizen(String name, String postalCode, int age, String email, String socSecNumber) {
        this.name = name;
        this.postalCode = postalCode;
        this.age = age;
        this.email = email;
        this.socSecNumber = socSecNumber;
    }

    public Citizen(String name, String postalCode, int age, String email, String socSecNumber, int numberOfVaccinations, LocalDateTime lastVaccination) {
        this.name = name;
        this.postalCode = postalCode;
        this.age = age;
        this.email = email;
        this.socSecNumber = socSecNumber;
        this.numberOfVaccinations = numberOfVaccinations;
        this.lastVaccination = lastVaccination;
    }

    public String getName() {
        return name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getSocSecNumber() {
        return socSecNumber;
    }

    public int getNumberOfVaccinations() {
        return numberOfVaccinations;
    }

    public LocalTime getScheduledVaccination() {
        return scheduledVaccination;
    }

    public LocalDateTime getLastVaccination() {
        return lastVaccination;
    }

    public void setScheduledVaccination(LocalTime scheduledVaccination) {
        this.scheduledVaccination = scheduledVaccination;
    }

    @Override
    public String toString() {
       /* return
                "name='" + name + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", socSecNumber='" + socSecNumber + '\'' +
                ", numberOfVaccinations=" + numberOfVaccinations +
                ", lastVaccination=" + lastVaccination + '\n'
                ;

*/        return
                scheduledVaccination + ", " + name + ", " + age + '\n';
    }


}
