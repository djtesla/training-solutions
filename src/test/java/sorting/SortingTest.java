package sorting;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    @Test
    public void sortingTest() {

        int[] n = {2,3,1,6};

        Arrays.sort(n);
        System.out.println(Arrays.toString(n));

        List<Integer> l = new ArrayList<>(List.of(2,5,18,5));

        l.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(l);



    Set<Trainer> names = new TreeSet<>(new Comparator<Trainer>() {
        @Override
        public int compare(Trainer o1, Trainer o2) {
            return o1.getSalary()-(o2.getSalary());
        }
    });
    names.add(new Trainer( "Gézu", 1000));
        names.add(new Trainer( "Lali", 3000));
        names.add(new Trainer( "Béci", 2000));

        System.out.println(names);

    }


}