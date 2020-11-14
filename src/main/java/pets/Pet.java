package pets;

import pets.Gender;

import java.time.LocalDate;

public class Pet {

    private String name;
    private LocalDate dayOfBirth;
    private Gender gender;
    private String registrationNumber;


    public Pet(String name, LocalDate dayOfBirth, Gender gender, String registrationNumber) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;


        if (registrationNumber.length() != 6) {
            throw new IllegalArgumentException();
        }
        this.registrationNumber = registrationNumber;

    }

    public String getName() {
        return name;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String toString() {
        return name + " - " + registrationNumber;
    }
}
