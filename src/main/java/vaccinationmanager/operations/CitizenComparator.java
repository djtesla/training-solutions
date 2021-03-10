package vaccinationmanager.operations;

import java.util.Comparator;

public class CitizenComparator implements Comparator<Citizen> {

    @Override
    public int compare(Citizen citizen1, Citizen citizen2) {
        if (citizen1.getAge() - citizen2.getAge() == 0) {
            return citizen1.getName().compareTo(citizen2.getName());
        }
        return citizen2.getAge() - citizen1.getAge();
    }
}