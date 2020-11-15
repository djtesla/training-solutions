package stringbasic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {


    @Test
    public void testEquals() {
        String s = "kacsa";

        String f = "kacsa";

        assertEquals(s,f);

        String u = new String("John");
        String t = new String("John");

        assertEquals(u,t);
        System.out.println(u == t);

    }
}
