package week13d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubjectManagerTest {

    @Test
    public void getLessonsByNameTest () {

        System.out.println(new SubjectManager().getLessonsByName("Albatrosz Aladin"));

    }


}