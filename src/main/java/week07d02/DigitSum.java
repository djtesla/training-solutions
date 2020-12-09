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

    //maradékos osztással és while ciklussal
    public int sumOfDigits2(int x) {

        int sum = 0;

        while (x != 0) {
            sum += x % 10;
            x = x / 10;
        }
        return sum;

    }


}





    /*Mai Junior/Mid-level feladat:
        Készíts egy week07d02.DigitSum osztályt és benne sumOfDigits(int x) metódus mely visszaadja
        a paraméterül kapott szám számjegyeinek összegét! pl.: 123 esetén a visszatérési érték 6. */

