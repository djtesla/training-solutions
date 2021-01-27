package collectionsset.collectionstreeset;

import java.util.*;

public class WordFilter {


    public Set<String> filterWords(String[] randomStrings) {

        List<String> words = Arrays.asList(randomStrings);

        return new TreeSet<>(words);

    }
}
