package week4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameChangerTest {


    @Test

    public void constructorTest () {

        NameChanger nameChanger = new NameChanger("Kiss János");

     assertEquals("Kiss János", nameChanger.getFullName());
    }

    @Test
    public void testChangeFirstName () {

        NameChanger nameChanger = new NameChanger("Kiss János");

        nameChanger.changeFirstName("Géza");;

        assertEquals("Kiss Géza",nameChanger.getFullName() );


    }

}