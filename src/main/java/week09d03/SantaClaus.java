package week09d03;

import java.util.List;

public class SantaClaus {

    private List<Person> persons;

    public SantaClaus(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return persons.toString();
    }

    public void getThroughChimneys () {
        for (Person person : persons) {
            person.setPresent();
        }
    }
}
