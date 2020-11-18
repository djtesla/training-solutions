package algorithmsmax.integers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxAgeCalculatorTest {

    @Test

    void TestTrainerWithMaxAge () {

        MaxAgeCalculator maxAgeCalculator = new MaxAgeCalculator();

        List<Trainer> trainers = new ArrayList<>();

        trainers.add(new Trainer("Einstein", 70));
        trainers.add(new Trainer("Teréz anya", 90));
        trainers.add(new Trainer("Zuckerberg", 36));

        assertEquals("Teréz anya", maxAgeCalculator.trainerWithMaxAge(trainers).getName());


    }

}