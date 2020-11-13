package controlselection.greetings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingsTest {

    @Test
public void testSayGreeting() {

    Greetings greetings = new Greetings();


    assertEquals("Good Night", greetings.getGreeting(3, 30));

    assertEquals("Good Night", greetings.getGreeting(4, 59));

    assertEquals("Good Night", greetings.getGreeting(0, 1));

    assertEquals("Good Night", greetings.getGreeting(20, 1));


}

}