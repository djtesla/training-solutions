package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {

    private Set<Book> books;

    public LibraryManager(Set<Book> books) {
        this.books = books;
    }


    public Book findBookByRegNumber(int regNumber) {

        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            Book focused = bookIterator.next();
            if (focused.getRegNumber() == regNumber) {
                return focused;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }



    public int removeBookByRegNumber(int regNumber) {

        for (Iterator<Book> iteratorBook = books.iterator(); iteratorBook.hasNext();) {
            Book focused = iteratorBook.next();
            if (focused.getRegNumber() == regNumber) {
                iteratorBook.remove();
                return regNumber;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }



    public Set<Book> selectBooksByAuthor(String author) {

        Set<Book> selectedBooks = new HashSet<>(books);
        Iterator<Book> bookIterator = selectedBooks.iterator();

        while (bookIterator.hasNext()) {
            Book focused = bookIterator.next();
            if (!focused.getAuthor().equals(author)) {
                bookIterator.remove();
            }
        }


        if (selectedBooks.size() == 0) {
            throw new MissingBookException("No books found by " + author);
        }
        return selectedBooks;
    }



    public int libraryBooksCount() {
        return books.size();
    }


}
