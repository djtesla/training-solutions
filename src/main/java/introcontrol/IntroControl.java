package introcontrol;

public class IntroControl {

    public int substractTenIfGreaterThanTen(int number) {
        if (number <= 10) {
        } else {
            number = number - 10;
        }
        return number;
    }

    public String describeNumber(int number) {
        String valasz;
        if (number == 0) {
            valasz = "zero";

        } else {
            valasz = "not zero";
        }
        return valasz;
    }

    public String greetingToJoe(String name) {
        if (name == "Joe") {
            return "Hello Joe";
        } else {
            return "";
        }
    }

    public double calculateBonus(int sale) {
        if (sale >= 1000000) {
            return sale * 0.1;

        } else {
            return 0;

        }
    }

    public int calculateConsumption(int prev, int next) {
        return 1;
    }

    public void printNumbers(int max) {

        for (int i = 0; i <= max; i++) {
            System.out.println(i);
        }
    }

    public void printNumbersBetween(int min, int max) {
        if (min >= 0 && max >= 0) {

            for (int i = min; i <= max; i++) {
                System.out.println(i);
            }
        }

    }

    public void printNumbersBetweenAnyDirection(int a, int b) {

        if (b > a) {
            for (int i = a + 1; i < b; i++)
                System.out.println(i);

        } else {
            for (int i = b - 1; i > a; i--)
                System.out.println(i);
        }
    }

    public void printOddNumbers(int max) {
        String valasz = "";
        for (int i = 1; i < max; i = i + 1) {


            if (i % 2 == 0) {
                valasz = "Páros szám: " + i;

            } else {
                valasz = "Páratlan szám jön.";
            }
            System.out.println(valasz);
        }
    }

}




