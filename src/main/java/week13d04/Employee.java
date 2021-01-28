package week13d04;

public class Employee {

    private String name;
    private int yearOfBirth;

    public Employee(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}


/*    Mai junior feladat:
        Írj egy a TemplateMerger osztályba egy public String merge(Path file, List<Employee> employees)
        metódust, ami felolvassa a fájlt, melynek tartalma:
        Az alkalmazott neve: {nev}, születési éve: {ev}
        Nyugodtan beolvashatod egy utasítással!
        Majd a visszatérési értékként add vissza soronként az alkalmazottakat, abban a formátumban,
        mint ahogy a fájlban van, azaz:
        Az alkalmazott neve: John Doe, születési éve: 1980
        Az alkalmazott neve: Jack Doe, születési éve: 1990
        (Persze ehhez kell egy Employee osztály is a megfelelő attribútumokkal.*/
