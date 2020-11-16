package week4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameChangerTest {


    @Test

    public void constructorTest () {

        //NameChanger nameChanger = new NameChanger("");

     assertThrows(IllegalArgumentException.class,() -> new NameChanger(""));

    }

    @Test
    public void testChangeFirstName () {

        NameChanger nameChanger = new NameChanger(null);

        nameChanger.changeFirstName("Géza");;

        assertEquals("Kiss Géza",nameChanger.getFullName() );


    }

    @Test
    public void istheSametest () {

        NameChanger nameChanger = new NameChanger(null);

        assertTrue(nameChanger.isTheSameTest());
    }

}