package week05.week05d03;

import org.junit.jupiter.api.Test;
import week05d03.User;
import week05d03.UserValidator;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;



class UserValidatorTest {


   UserValidator uv = new UserValidator();

    @Test
    public void testValidateIfTrue () {



        assertTrue(
                uv.validate(Arrays.asList(new User("Kiss Ramóna", 36),
                        new User("Bártfai Csilla", 12),
                        new User("Nagy Jánosné", 75)))
        );
    }


    @Test
    public void testValidateIfNameIsEmpty () {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> uv.validate(Arrays.asList(
                new User("",36),
                new  User("Bártfai Csilla", 12 ),
                new User("Nagy Jánosné", 75)))
        );
        assertEquals("user name cannot be empty!", ex.getMessage());
    }

    @Test
    public void testValidateIfNameIsBlank () {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> uv.validate(Arrays.asList(
                new User("    ",36),
                new  User("Bártfai Csilla", 12 ),
                new User("Nagy Jánosné", 75)))
        );
        assertEquals("user name cannot be empty!", ex.getMessage());
    }

    @Test
    public void testValidateIfNameIsNull () {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> uv.validate(Arrays.asList(
                new User(null,36),
                new  User("Bártfai Csilla", 12 ),
                new User("Nagy Jánosné", 75)))
        );
        assertEquals("user name cannot be empty!", ex.getMessage());
    }

    @Test
    public void testValidateIfAgeIsMinus () {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> uv.validate(Arrays.asList(
                new User("Kiss Ramóna",-36),
                new  User("Bártfai Csilla", 12 ),
                new User("Nagy Jánosné", 75)))
        );
        assertEquals("age must be between 0 and 120!", ex.getMessage());
    }

    @Test
    public void testValidateIfAgeIsToobig () {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> uv.validate(Arrays.asList(
                new User("Kiss Ramóna",36),
                new  User("Bártfai Csilla", 12 ),
                new User("Nagy Jánosné", 125)))
        );
        assertEquals("age must be between 0 and 120!", ex.getMessage());
    }

}