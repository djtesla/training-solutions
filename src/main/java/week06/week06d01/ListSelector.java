package week06.week06d01;

import java.util.List;

public class ListSelector {

    public String concatenateEverySecond (List<String> elements) {

        StringBuilder concatenatedText = new StringBuilder();
        if (elements == null) {
            throw new IllegalArgumentException("List doesn't contain any element!");
        }

        if (elements.size() != 0) {
            concatenatedText.append("[" + elements.get(0));
            for (int i = 2; i < elements.size(); i+=2) {
            concatenatedText.append("," + elements.get(i));
            }
            concatenatedText.append("]");
        }
        return concatenatedText.toString();
    }


}

/*
Junior/Mid level csoport mai gyakorlati feladata:
        Írj egy olyan metódust az week06d01.ListSelector osztályban, mely egy kapott listából minden második
        elemet kiválogat, és egy szövegként összerak, szögletes zárójelek között.
        A páros megállapítása index szerint működik. Azaz az első, nulla indexű elem páros, a második, azaz
        egyes indexű elem páratlan, stb.
        Ha üres a lista, akkor üres stringet adjunk vissza. Ha a paraméterül kapott lista null, akkor dobjunk
        IllegalArgumentExceptiont a metódusban.*/
