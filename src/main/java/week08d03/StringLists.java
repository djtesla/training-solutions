package week08d03;

import java.util.ArrayList;
import java.util.List;

public class StringLists {



    public List<String> stringListsUnion(List<String> first, List<String> second) {

        List<String> unifiedList = new ArrayList<>(first);

        for (String element : second) {
            if (!isIncluded(unifiedList, element)) {
                unifiedList.add(element);
            }
        }
        return unifiedList;
    }

    private boolean isIncluded(List<String> unifiedList, String element ) {

        for (String e : unifiedList) {
            if (e.equals(element)) {
                return true;
            }
        }
        return false;
    }


}


/*    Mai Junior/Mid-level feladat:
        Készíts week08d03 csomagban egy StringLists osztályt és benne egy stringListsUnion(List<String> first, List<String> second)
        metódust, mely két string listát vár paraméterül és visszaadja az uniójukat. Az úniónak minden elemet tartalmaznia kell mindkét
        listából, de egy elem nem szerepelhet kétszer!*/
