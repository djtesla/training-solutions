package week06d03;

import java.util.ArrayList;
import java.util.List;

public class WordEraser {


    public String eraseWord(String words, String word) {

        List<String> filteredList = new ArrayList<>();
        String[]wordsArray = words.split(" ");

        for (String item: wordsArray) {
            if (!item.equals(word)) {
                filteredList.add(item);
            }
        }
        return String.join(" ", filteredList);
    }
}

  /*  Mai Junior/Mid-level feladat. A week06d03.WordEraser osztályban legyen egy eraseWord(String words, String word)
        metódus, mely az első paraméter szöveget úgy változtatja meg, hogy a második paraméter összes előforulását
        kitörli belőle. A words paraméterben a szavak szóközzel vannak elválasztva. A metódus térjen vissza a törölni kívánt
        szavak nélküli Stringgel. (Mellőzzük a replace és replaceAll használatát)*/