package primitivetypes;

import java.util.ArrayList;
import java.util.List;

public class PrimitiveTypes {

    public static void main(String[] args) {
        int i = 5;

        Integer j = new Integer(5); // nincs rá szükség, mert az uatoboxingot megcsinálja a JVM

        List<Integer> numbers = new ArrayList<>();
        numbers.add(j);
    }
}
