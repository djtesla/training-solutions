package week08d02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

    @Test
    public void getNumberTest () {

        for (int i = 0; i < 100; i++) {
            List<Integer> numbers = new Lottery().getNumbers();
            System.out.println(numbers);
        }

    }

}