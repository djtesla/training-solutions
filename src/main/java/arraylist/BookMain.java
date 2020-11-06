package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookMain {


    public static void main(String[] args) {
        Book book = new Book();

        book.add("A rút kiskacsa");
        book.add("A kis gézengúz");
        book.add("Hasutasok");
        book.add("Hasra pacsi");
        book.add("Az aranyember");

        List<String> filteredTitles = new ArrayList<>();

        filteredTitles = book.findAllByPrefix("Az");

        for (String title: filteredTitles) {
            System.out.println(title);
        }

        book.removeByPrefix("A rút");
        System.out.println(book.getTitles());

    }
}
