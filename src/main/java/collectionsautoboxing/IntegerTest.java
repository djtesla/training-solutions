package collectionsautoboxing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerTest {


    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(5);

        int x = l.get(0);

        Map<Character, Integer>m = new HashMap<>();
        m.put('a', 1);
        m.put('a', m.get('a')+1);

        System.out.println(m.get('a'));


    }


}
