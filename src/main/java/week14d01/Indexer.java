package week14d01;

import java.util.*;

public class Indexer {

    public Map<Character, List<String>> index(List<String> names) {

        Map<Character, List<String>> firstCharsAndNames = new TreeMap<>();
        for (String name : names) {
            char firstCharOfName = name.charAt(0);
            List<String> updatedNameList = getUpdatedNameList(firstCharOfName, name, firstCharsAndNames);
            firstCharsAndNames.put(firstCharOfName, updatedNameList);
        }
        return firstCharsAndNames;
    }


    private List<String> getUpdatedNameList(char firstCharOfName, String name, Map<Character, List<String>> firstCharsAndNames) {

        List<String> updatedNameList;
        if (firstCharsAndNames.keySet().contains(firstCharOfName)) {
            updatedNameList = firstCharsAndNames.get(firstCharOfName);
            updatedNameList.add(name);
        } else {
            updatedNameList = new ArrayList<>();
            updatedNameList.add(name);
        }
        return updatedNameList;
    }


}






/*    Mai junior/medior feladat:
        Készíts egy Indexer osztályt, melynek van egy public Map<Character, List<String>> index(List<String> names) metódusa.
        A feladat az, hogy egy indexet készítsünk a megadott nevek kezdőbetűiből (minden kezdőbetűt társítsunk az összes névvel,
         mely ezzel a betűvel kezdődik).
        Példa:
        System.out.println(new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna")));
// {A=[Abraham], L=[Lujza], M=[Magdolna], O=[Odon]}*/
