package week08d05;

import java.util.ArrayList;
import java.util.List;

public class MathAlgorithms {


    public int greatestCommonDivisor(int number1, int number2) {

        List<Integer> number1Dividers = getDividers(number1);
        List<Integer> number2Dividers = getDividers(number2);

        List<Integer> union = getUnion(number1Dividers, number2Dividers);

        return getBiggestElement(union);
    }



    public List<Integer> getDividers(int number) {

        List<Integer> dividers = new ArrayList<>();

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                dividers.add(i);
            }
        }
        dividers.add(number);
        return dividers;
    }


    public List<Integer> getUnion(List<Integer> number1Dividers, List<Integer> number2Dividers) {

        List<Integer> union = new ArrayList<>();

        for (int n : number2Dividers) {
            if (number1Dividers.contains(n)) {
                union.add(n);
            }
        }
        return union;
    }


    public int getBiggestElement(List<Integer> elements) {

        int biggestElement = 1;

        for (int e : elements) {

            if (e > biggestElement) {
                biggestElement = e;
            }
        }
        return biggestElement;
    }
}




/*
    A week08d05 csomagban készíts egy osztályt MathAlgorithms néven. Legyen benne egy metódus, greatestCommonDivisor()
        , ami paraméterül vár két pozitív egész számot és visszaadja a legnagyobb közös osztójukat.*/
