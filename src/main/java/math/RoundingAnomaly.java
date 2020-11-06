package math;

import java.util.Random;

public class RoundingAnomaly {

    public static final Random RND = new Random();



    public double[] randomNumbers(int size, double max, int scale) {

        double[] randomNumbers = new double[size];
        double multipilier = Math.pow(10, scale);

        for (int i = 0; i < size; i++ ) {

            double randomNumber = RND.nextDouble();
            randomNumber = Math.round(randomNumber * multipilier * max);
            randomNumber = randomNumber / multipilier;

            // System.out.println(randomNumber);
            randomNumbers [i] = randomNumber;
        }

        return randomNumbers;
    }



    double roundAfterSum(double numbers[]) {

        double roundAfterSum = 0.0;
        for (int i = 0; i < numbers.length; i++ ) {
            roundAfterSum += numbers[i];
        }
        return Math.round(roundAfterSum);
    }



    double sumAfterRound(double numbers[]) {

        double roundAfterSum = 0.0;
        for (int i = 0; i < numbers.length; i++ ) {
            roundAfterSum += Math.round(numbers[i]);
        }
        return roundAfterSum;

    }



    double difference(int size, double max, int scale) {

        double averageRoundAfterSum = 0;
        double averagerSumAfterRound = 0;

        for (int i = 0; i < 100; i++) {

            double[] arrayGenerated = randomNumbers(size, max, scale);
            double roundAfterSum = roundAfterSum(arrayGenerated);
            double sumAfterRound = sumAfterRound(arrayGenerated);

            averageRoundAfterSum += roundAfterSum;
            averagerSumAfterRound += sumAfterRound;
        }

        averageRoundAfterSum /= 100;
        averagerSumAfterRound /= 100;

        return averageRoundAfterSum - averagerSumAfterRound;
    }



    public static void main(String[] args) {
        RoundingAnomaly roundingAnomaly = new RoundingAnomaly();

        // roundingAnomaly.randomNumbers(5, 1000000, 5);

        // System.out.println(roundingAnomaly.roundAfterSum(roundingAnomaly.randomNumbers(5, 1000000, 5)));

        // System.out.println(roundingAnomaly.sumAfterRound(roundingAnomaly.randomNumbers(5, 1000000, 5)));

        System.out.println(roundingAnomaly.difference(5, 1000000, 5));

    }
}
