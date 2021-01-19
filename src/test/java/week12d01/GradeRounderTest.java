package week12d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GradeRounderTest {

    @Test

    public void roundGradesTest() {

        assertEquals("[80, 80, 80, 85, 85, 85]", (Arrays.toString(new GradeRounder().roundGrades(new int[]{80, 81, 82, 83, 84, 85}))));

    }

}