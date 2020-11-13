package introjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GentlemanTest {


    @Test
    public void TestSayHello() {


        // Given
        Gentleman gentleman = new Gentleman();

        // When
        String greeting = gentleman.sayHello("Ernő");
        String x = null;

        // Then
        assertEquals("Hello Ernő!", greeting);



    }

    @Test
    public void TestSayHello2() {
        Gentleman gentleman = new Gentleman();
        String greeting = gentleman.sayHello(null);
        assertEquals("Hello Anonymus!", greeting);
    }

}






