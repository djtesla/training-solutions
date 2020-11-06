package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private List<String> titles = new ArrayList<>();

    public void add(String title) {

        titles.add(title);

    }

    public List<String> findAllByPrefix(String prefix) {
        List <String> filteredTitles = new ArrayList<>();
        for (String title: titles) {

            if (title.substring(0,prefix.length()).equals(prefix)) {
                filteredTitles.add(title);
            }
        }
        return filteredTitles;

    }

    public List<String> getTitles () {
        return titles;
    }

    public void removeByPrefix(String prefix) {

        for (int i = 0; i < titles.size(); i++) {

            if (titles.get(i).startsWith(prefix)) {
                titles.remove(i);
            }
        }


    }
}
