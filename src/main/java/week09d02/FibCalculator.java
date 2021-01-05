package week09d02;

import java.util.ArrayList;
import java.util.List;

public class FibCalculator {


    public long sumEvens(int bound) {

        int sum = 0, i = 0, nextE = 0;

        List<Integer> fibNumbers = new ArrayList<>();

        while (i < 3 || fibNumbers.get(i - 1) + fibNumbers.get(i - 2) <= bound) {

            i++;
            nextE =getNextFibNumber(i, fibNumbers);
            fibNumbers.add(nextE);

            if (nextE % 2 == 0) {
                sum += nextE;
            }

        }

        System.out.println(fibNumbers);
        return sum;
    }




    public int getNextFibNumber(int index, List<Integer> fibNumbers) {

        if (index < 3) {
            return  1;
        } else {
            return fibNumbers.get(index - 2) + fibNumbers.get(index - 3);
        }

    }


}


// összeadja a páros fibonacci számokat addig, amig a következő fibonacci szám nem nagyobb, mint bound, majd visszadja a végredményt.