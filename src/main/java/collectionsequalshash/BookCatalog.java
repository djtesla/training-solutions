package collectionsequalshash;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {


    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {

        for (Book book : books) {

            if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }





    public Book findBook(List<Book> books, Book book) {

        for (Book bookFocused : books) {

            if (bookFocused.equals(book)) {
                return book;
            }
        }
        return null;
    }





    public Set<Book> addBooksToSet(Book[] books) {

        Set<Book> bookSet = new LinkedHashSet<>();

        for (Book book: books) {
            bookSet.add(book);

        }


        return bookSet;
    }




}
