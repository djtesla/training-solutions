package catalog;

import java.util.List;

public class Validators {

    public static boolean isBlank (String text){

        return text == null || "".equals((text.trim()));


    }

    public static boolean isEmpty (List<String> texts){

        return texts == null || texts.size() == 0;


    }
}
