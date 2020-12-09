package week07d03;

import java.util.List;

public class NumberList {

    public boolean isIncreasing(List<Integer> numbers) {

        int prevNum;

        for (int i = 0; i < numbers.size()-1; i++) {
            if (numbers.get(i + 1) < numbers.get(i)) {
                return false;
            }
        }
        return true;
    }
}
