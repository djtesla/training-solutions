package collectionsclass;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class CollectionsTest {


    @Test

    public void collectionsTest() {

        //List<Integer> l = Collections.singletonList(5);
        List<Integer> l = new ArrayList<>(List.of(5,4,6,7,8));

        //l.add(5);

        List<Integer> l2 = Collections.unmodifiableList(l);

        //System.out.println(l2);
        l.add(4);
        //System.out.println(l2);

        Collections.reverse(l);
        //System.out.println(l);

        Collections.shuffle(l, new Random(10));
        System.out.println(l);






    }

}