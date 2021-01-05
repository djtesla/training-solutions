package week09d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SantaClausTest {

    @Test
    public void getThroughChimneysTest() {

        SantaClaus santaClaus = new SantaClaus(Arrays.asList(new Person("Jocika", 12),
                new Person("Jocika", 6),
                new Person("Gizike", 6),
                new Person("Bécike", 7),
                new Person("Trudika", 8),
                new Person("Trudika", 9),
                new Person("Trudika", 10),
                new Person("Jocika", 11),
                new Person("Gizike", 12),
                new Person("Bécike", 22),
                new Person("Trudika", 43),
                new Person("Trudika", 33),
                new Person("Trudika", 20),
                new Person("Bécike", 22),
                new Person("Trudika", 43),
                new Person("Trudika", 33),
                new Person("Trudika", 20)));

        santaClaus.getThroughChimneys();

        System.out.println(santaClaus);

    }
}