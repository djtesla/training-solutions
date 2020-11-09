package objects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMain {

    public static void main(String[] args) {

       new Book();

        System.out.println(new Book());

        Book emptyBook = new Book();

        emptyBook = null;

        System.out.println(emptyBook);

        System.out.println(emptyBook == null);

        Book book = new Book();

        System.out.println(book);
        book = emptyBook;

        System.out.println(book);

        Book anotherBook = new Book();


        System.out.println(anotherBook == book);

        book = anotherBook;

        System.out.println(anotherBook == book);

        System.out.println(anotherBook instanceof Book);



    Book[] arrayOfBooks = {new Book(),new Book(), new Book()};

    List<Book> books = Arrays.asList(new Book(),new Book(), new Book());

    List<Book> books2 = new ArrayList<>();

    books.add(new Book());
    books.add(new Book());
    books.add(new Book());





    }
}
