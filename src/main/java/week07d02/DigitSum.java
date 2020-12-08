package week07d02;

public class DigitSum {

    public int sumOfDigits(int x) {

        int sum = 0;

        String digits = Integer.toString(x);

        for (char i : digits.toCharArray()) {

            sum += Character.getNumericValue(i);

        }

        return sum;
    }


}


    /*Mai Junior/Mid-level feladat:
        Készíts egy week07d02.DigitSum osztályt és benne sumOfDigits(int x) metódus mely visszaadja
        a paraméterül kapott szám számjegyeinek összegét! pl.: 123 esetén a visszatérési érték 6. */

