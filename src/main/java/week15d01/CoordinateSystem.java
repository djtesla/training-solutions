package week15d01;

import java.util.*;

public class CoordinateSystem {


    public Map.Entry<Double, Double> getCoordinateWithMaxValue(Map<Double, Double> map) {

        if (map.size() == 0) {
            throw new IllegalArgumentException("Map size cannot be empty!");
        }

        Map.Entry<Double, Double> entryMax = null;
        double max = Double.MIN_VALUE;

        for (Map.Entry<Double, Double> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                entryMax = entry;
                max = entry.getValue();
            }
        }
        return entryMax;
    }


    public static void main(String[] args) {
        int[] t1 = {1,2,3,4,5};
        int[] t2 = t1;
        t2[0] = 9;

        //System.out.println(Arrays.toString(t1));

        Map<String, String> map = new HashMap<>();
        Set<String> set = new LinkedHashSet<>();

        map.put("Papi", "csórikám");
        map.put("Mapi", "csórikám");
        map.put("Laci", "csórikám");

        System.out.println(map);;
    }

}





    /*Adott egy függvénygrafikon a koordináta rendszerben. A grafikon néhány pontját megkapjuk egy Map-ben.
        A map kulcsa az x koordináta értéke pedig az y koordináta. Döntsük el, hogy a kapott pontok küzül,
        hol van a függvénynek maximum helye és ott mennyi az értéke. (edited) */