package exam03retake01;

public class CdvCheck {


    public boolean check(String taxNumber) {
        if (taxNumber.length() != 10) {
            throw new IllegalArgumentException ("Tax number must be 10 digit long");
        }
        int sum = 0;
        for (int i = 0; i < taxNumber.length()-1; i++) {
            int digit = getNumericValueOfChar(taxNumber.charAt(i));
            sum += digit * (i + 1);
        }
        int lastDigit = getNumericValueOfChar(taxNumber.charAt(9));
        return sum % 11 == lastDigit;
    }


    private int getNumericValueOfChar(char c) {
        int digit;
        try {
            digit = Integer.parseInt(String.valueOf(c));
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Tax number contains invalid character");
        }
        return digit;
    }



}

/*

    Írj egy CdvCheck.check() metódust (paraméterezése, visszatérési értéke kiderül a tesztesetből),
        mely kap egy adószámot, és eldönti róla, hogy helyes-e! A következőképp kell eldönteni.
        Fogni kell az első kilenc számjegyet, és megszorozni rendre 1, 2, ..., 9 számmal. Az eredményt
        kell összegezni, majd maradékos osztani 11-el. A 10. számjegynek meg kell egyeznie ezzel a számmal
        (maradékkal).

        Pl.:

        8365670003
        1 * 8 + 2 * 3 + 3 * 6 + ... + 9 * 0 = 124
        124 maradékos osztás 11-el = 3
        3 (maradék) == 3 (10. számhegy) - az adószám megfelelő
        Ha a paraméterként átadott adószám nem 10 számjegy, vagy nem csak számjegy szerepel benne,
        IllegalArgumentException kivételt kell dobni.
*/
