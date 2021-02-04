package searching;

import org.junit.jupiter.api.Test;

import java.security.spec.NamedParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    @Test

    public void searchTest() {

        int[] n = {0, 1, 2, 7, 2, 2, 6, 4, 5, 3, 9};
        Arrays.sort(n);
        int i = Arrays.binarySearch(n, 10);
        //System.out.println(i);

        List<Integer> l = new ArrayList<>(List.of(11,1,2,3,4,1,6,7,8));
        Collections.sort(l);

        List<Trainer> t = new ArrayList<>(List.of(new Trainer("Gézu", 2000),
                new Trainer("Béci", 3000), new Trainer("Lali", 1000)));


        System.out.println(Collections.max(t));
        Collections.sort(t);
        System.out.println(Collections.binarySearch(t,new Trainer("Gézu", 2000)));

        //System.out.println(Collections.binarySearch(t,new Trainer("Gézu", 2000)));
    }

}