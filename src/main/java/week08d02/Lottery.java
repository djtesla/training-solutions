package week08d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {


    public List<Integer> getNumbers() {

        List<Integer> numbers = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 1; i <= 5; i++) {
            int number = rnd.nextInt(90) + 1;

            while (!isNumberAddable(number, numbers)) {
                number = rnd.nextInt(90) + 1;
            }
            numbers.add(number);
        }

        return numbers;
    }


    public boolean isNumberAddable(int number, List<Integer> numbers) {

        for (int n : numbers) {
            if (n == number) {
                return false;
            }
        }
        return true;
    }

}


 /*   Mai Junior/Mid-level feladat:
    Készíts a week08d02 csomagban egy Lottery osztályt, melynek legyen egy getNumbers() metódusa, ami visszaad egy listát
    amiben 5 véletlen szám van 1-90 között, tehát kvázi készíts egy lottósorsoló programot. A sorrendre nem kell figyelni,
    a lényeg, hogy a számok különbözők legyenek*/
