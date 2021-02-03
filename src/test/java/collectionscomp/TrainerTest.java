package collectionscomp;

import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    @Test
    public void trainerTest() {

        List<String> names = new ArrayList<>(List.of("Géza", "Béla", "Cecilke"));
        Collections.sort(names);


        List<Trainer> trainers = new ArrayList<>(List.of(
                new Trainer("Géza", 1000),
                new Trainer("Áron", 3000),
                new Trainer("Cecilke", 2000)));

        Collections.sort(trainers);


        //Collections.sort(trainers, Collator.getInstance(new Locale("hu","HU")));
        System.out.println(trainers);

        Collections.sort(trainers, new SalaryComparator());



    }

    public class NameComparator implements Comparator<Trainer> {

                @Override
        public int compare(Trainer t1, Trainer t2) {
            return t1.getName().compareTo(t2.getName());
        }
    }

    public class SalaryComparator implements Comparator<Trainer> {

        @Override
        public int compare(Trainer t1, Trainer t2) {
            return t1.getSalary() - t2.getSalary();
        }
    }

}