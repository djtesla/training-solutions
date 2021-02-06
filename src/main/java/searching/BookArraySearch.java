package searching;

import java.util.Arrays;

public class BookArraySearch {

    private Book[]books;

    public BookArraySearch(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }



    public Book findBookByAuthorTitle(String author, String title) {

        if (isEmpty(author) || isEmpty(title)) {
            throw new IllegalArgumentException ("Author or title must not be empty!");
        }


        int i = Arrays.binarySearch(books,new Book(author, title));
        if (i >-1) {
            return books[i];        }
        throw new IllegalArgumentException("No book found by " + author + " with title " + title);
    }

    public boolean isEmpty(String text) {
        return text == null || "".equals(text.trim());
    }
}
