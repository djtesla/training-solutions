package week11d01;

public class DivisorFinder {




    public int findDivisors(int n) {

        int sum = 0;
        String numberStr = Integer.toString(n);


        for (int i = 0; i < numberStr.length(); i++) {


            if (Integer.parseInt(String.valueOf(numberStr.charAt(i))) == 0) {
                System.out.println("Hamiskodsz, 0 van a számjegyek között, amivel nem osztunk! De azért nézem a számokat tovább!");
                continue;
            }
            if (n %  Integer.parseInt(String.valueOf(numberStr.charAt(i))) == 0) {
                sum += 1;
            }
        }
        return sum;
    }
}


/*    Készítsünk egy DivisorFinder nevű osztályt, melynek van egy int findDivisors(int n) metódusa.
        A feladat az, hogy megnézzük a szám minden egyes számjegyére, hogy osztója-e a számnak, majd
        számoljuk össze őket. Példa: a 425-ben az 5 osztója a számnak, ezért a visszatérési érték 1.*/
