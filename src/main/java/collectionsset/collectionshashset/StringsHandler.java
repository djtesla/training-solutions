package collectionsset.collectionshashset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StringsHandler {


    public Set<String> filterUniqueStrings(Collection<String> stringCollection) {

        Set<String> uniqueStrings = new HashSet<>();

        for (String element: stringCollection) {
            uniqueStrings.add(element);
        }
        return uniqueStrings;
    }


    public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB) {

        Set<String> identicalStrings = new HashSet<>(setA);

        for (String element: setB) {
            identicalStrings.add(element);
        }
        return identicalStrings;
    }


}
