package week05d01;

import java.util.Map;

public class CoordinateSystem {


    public double getCoordinateWithMaxValue(Map<Double, Double> map) {

        double max = 0;
        int count = 0;

        for (Map.Entry entry : map.entrySet()) {
            count++;
            if (count == 1) {
                max = (double) entry.getValue();
            } else {
                if ((double) entry.getValue() > max) {
                    max = (double) entry.getValue();
                }
            }
        }
        return max;
    }

}





    /*Adott egy függvénygrafikon a koordináta rendszerben. A grafikon néhány pontját megkapjuk egy Map-ben.
        A map kulcsa az x koordináta értéke pedig az y koordináta. Döntsük el, hogy a kapott pontok küzül,
        hol van a függvénynek maximum helye és ott mennyi az értéke. (edited) */