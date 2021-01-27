package genericsusage.withgenerics;

import java.util.List;

public class Library {

    public Book getFirstBook(List<Book> books) {

        if (books == null) {
            throw new NullPointerException("Books list is null");
        }

        if (books.size() == 0) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }

        return books.get(0);
    }





}



