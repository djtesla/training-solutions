package exceptions.polinom;

public class Polynomial {

    private double[] coefficients;

    public Polynomial(double[] coefficients) {

        if (coefficients == null) {
            throw new NullPointerException ("coefficients is null");
        }

        this.coefficients = coefficients;
    }



    public Polynomial(String[] coefficientsStrs) {


        if (coefficientsStrs == null) {
            throw new NullPointerException ("coefficientStrs is null");
        }


        double[] coefficients = new double[coefficientsStrs.length];
        int i = 0;
        for (String str: coefficientsStrs ) {

            try {
                coefficients[i] = Integer.parseInt(str);
            }
            catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("Illegal coefficients, not a number", nfe);
            }
            i++;
        }
        this.coefficients = coefficients;
    }



    public double[] getCoefficients() {
        return coefficients;
    }


    public double evaluate(double x) {
        int n = coefficients.length - 1;
        double sum = 0;
        for (int j = n; j >= 0; j--) {
            sum += coefficients[j] * Math.pow(x,(double)n - j);
        }
        return sum;
    }



}


/*Gyakorlat 1 - Polinom példa
        Készítsen egy Polinom osztályt, amelynek segítségével tetszőleges polynomial értékét ki tudjuk számolni adott x értéknél.
        A polinomot az együtthatóinak a tömbje írja le. A polinomot lehessen inicializálni az együtthatók tömbjével (double[]), de
        lehessen inicializálni String[] -el is (pl. beolvasott értékek). Az osztálynak legyen egy public double evaluate(double x)
        metódusa, amely adott x értéknél visszaadja a polynomial értékét. Valamint legyen getter az együtthatók tömbjére. A double[]
        paraméterű konstruktor dobjon NullPointerException kivételt, ha a paraméter null. A String[] paraméterű konstruktor dobjon
        NullPointerException kivételt, ha a paraméter null, valamint dobjon IllegalArgumentException-t ha az egyes String-ek nem
        alakíthatók double számmá.

        Mi az a polinom?
        https://hu.wikipedia.org/wiki/Polinom*/
