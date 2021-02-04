package sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class OrderedArrayLibrary {

    private Book[] bookArray;

    public OrderedArrayLibrary(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book[] getBookArray() {
        return bookArray;
    }


    public Book[] sortingById() {

        Book[] sortedByIdArr = new Book[bookArray.length];
        System.arraycopy(bookArray, 0, sortedByIdArr, 0, bookArray.length);
        Arrays.sort(sortedByIdArr);
        return sortedByIdArr;
    }


    public Book[] sortingByTitle() {

        Comparator<Book> titleComparator = new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        };
        Book[] sortedByIdArr = new Book[bookArray.length];
        System.arraycopy(bookArray, 0, sortedByIdArr, 0, bookArray.length);
        Arrays.sort(sortedByIdArr, titleComparator);

        return sortedByIdArr;

    }


}





