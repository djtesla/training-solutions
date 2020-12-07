package week07d01;

public class MathAlgorithms {


    public static boolean isPrime (int x) {

        if (x < 0) {
            throw new IllegalArgumentException("Number cannot be negative!");
        }

        int numberOfDividers = 0;

        for (int i = 2; i <= x/2; i++) {

            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}


/*
unior/Mid-Level csoport mai feladata:
        Készíts egy osztályt a week07d01 csomagba MathAlgorithms néven. Ebben az osztályban legyen egy
        isPrime(int x) metódus ami a paraméterül kapott számról eldönti, hogy prím-e vagy sem és ennek
        megfelelően true vagy false értékkel tér vissza. Aki már tart ott és tudja mit jelent a static
az nyugodtan implementálhatja a metódust statikus metódusként. Az egyszerűség kedvért a prímeket most csak
        a pozitív egész számok körében értelmezzük, így bónuszként rá lehet ellenőrizni, hogy x>0  és ha nem
        akkor kivételt dobni. Prímeknek tekintjük azokat számokat melyek csak egyel és önmagukkal oszthatók,
        tehát a 2,3,5,7,11,13 stb. Teszt!!*/
