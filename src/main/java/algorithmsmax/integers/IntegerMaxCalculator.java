package algorithmsmax.integers;

import java.util.List;

public class IntegerMaxCalculator {


    public int max(List<Integer> numbers) {

        int max = 0;

        for (int i : numbers) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
