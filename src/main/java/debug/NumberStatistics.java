package debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberStatistics {

    private List<Integer> numbers = new ArrayList<>();

    public NumberStatistics(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int sumPositives() {
        int sum = 0;
        for (int n : numbers) {
            if (n > 0) {
                sum += n;
            }
        }
        return sum;
    }

    public int minDifferenceBetweenNeighbours() {
        int minDifference = Math.abs(numbers.get(0) - numbers.get(1));
        for (int i = 1; i < numbers.size() - 1; i++) {
            int actDifference = Math.abs(numbers.get(i) - numbers.get(i + 1));
            if (actDifference < minDifference) {
                minDifference = actDifference;
            }
        }
        return minDifference;
    }

    public static void main(String[] args) {

        // List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        NumberStatistics numberStatistics = new NumberStatistics(Arrays.asList(4, 8, -1, -2, 4, 5, 3));

        System.out.println(numberStatistics.sumPositives());

        System.out.println(numberStatistics.minDifferenceBetweenNeighbours());


    }
}
