package collectionsiterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {


    public static void main(String[] args) {


        List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Iterator<Integer> i = values.iterator();

        while (i.hasNext()) {
            int value = i.next();

            if (value % 2 == 0) {
                i.remove();
            }
        }

        System.out.println(values);


    }

}
