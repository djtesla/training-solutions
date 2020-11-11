package typeconversion.whichtype;

import java.util.ArrayList;
import java.util.List;

public class WhichType {

    public List<Type> whichType(String s) {

        List<Type> rangeList = new ArrayList<>();
        long num = Long.parseLong(s);

        for (Type type : Type.values()) {

            if (type.getMin() <= num && type.getMax() >= num) {
                rangeList.add(type);

            }
        }
    return rangeList;
    }

    public static void main(String[] args) {

        WhichType whichType = new WhichType();

        System.out.println(whichType.whichType("1000"));

    }
}
