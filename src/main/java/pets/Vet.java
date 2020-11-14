package pets;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vet {

    private List<Pet> pets = new ArrayList<>();

    public void add(Pet pet) {


            for (Pet pet1 : pets) {

                if (areEquals(pet1, pet)) {
                return;
            }

        }
        pets.add(pet);
    }


    public List<Pet> getPets() {
        return pets;
    }

    public boolean areEquals(Pet pet1, Pet pet2) {

        return pet1.getRegistrationNumber().equals(pet2.getRegistrationNumber());
    }


    public static void main(String[] args) {

        Vet vet = new Vet();
        try {
            vet.add(new Pet("Rudi a rigó", LocalDate.of(2020, 10, 10), Gender.MALE, "A00147"));
            vet.add(new Pet("Londoni bohóchal", LocalDate.of(2020, 10, 10), Gender.FEMALE, "A00137"));
            vet.add(new Pet("Xavér a varjú", LocalDate.of(2020, 10, 10), Gender.UNKNOWN, "A00147"));
            vet.add(new Pet("Kokó a koca", LocalDate.of(2020, 10, 10), Gender.MALE, "000148"));
        } catch (IllegalArgumentException e) {
            System.out.println("Nem 6 jegyű regisztrációs számot adtál meg!");
            }

        System.out.println(vet.pets.size());
        System.out.println(vet.pets);

        }

    }

