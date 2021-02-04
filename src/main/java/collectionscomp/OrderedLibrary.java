package collectionscomp;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {

    private List<Book> libraryBooks;

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }


    public List<Book> orderedByTitle() {
        List<Book> libraryBooksOrderedByTitle = new ArrayList<>(libraryBooks);
        Collections.sort(libraryBooksOrderedByTitle);
        return libraryBooksOrderedByTitle;
    }


    public List<Book> orderedByAuthor() {
        List<Book> libraryBooksOrderedByAuthor = new ArrayList<>(libraryBooks);
        Collections.sort(libraryBooksOrderedByAuthor, new AuthorComparator());
        return libraryBooksOrderedByAuthor;
    }


    public List<String> orderedByTitleLocale(Locale locale) {
        List<String> bookTitles = new ArrayList<>();
        for (Book book : libraryBooks) {
            bookTitles.add(book.getTitle());
        }
        Collections.sort(bookTitles, Collator.getInstance(new Locale("hu", "HU")));
        return bookTitles;
    }


}
