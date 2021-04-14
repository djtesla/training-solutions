package lambdastreams;

import java.util.*;
import java.util.stream.Collectors;

public class BookStore {

    List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }


    public int getNumberOfBooks() {
        return books.stream().map(Book::getPieces).reduce(0, (i, n) -> n + i);
    }


    public Book findNewestBook() {
        return books.stream().min(Comparator.comparing(Book::getYearOfPublish).reversed()).get();
    }


    public int getTotalValue() {
        return books.stream().
                map(Book::getPrice).reduce(0, (p1, p2) -> p1 + p2);
    }

    public List<Book> getByYearOfPublish(int year) {
        return books.stream().filter(book -> book.getYearOfPublish() == year).collect(Collectors.toList());
    }

    public Map<Integer, List<Book>> getByYearOfPublishWithGroupingBy() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getYearOfPublish));

    }



    public static void main(String[] args) {
        BookStore bs = new BookStore(Arrays.asList(new Book("Géza élete", 2002, 2990, 12),
                new Book("Emily élete", 2020, 4990, 10),
                new Book("Óz vacsorája", 2000, 1990, 2),
                new Book("Tiffany kalandjai", 2002, 5990, 5)));

        System.out.println(bs.getNumberOfBooks());
        System.out.println(bs.findNewestBook());
        System.out.println(bs.getTotalValue());
        System.out.println(bs.getByYearOfPublish(2002));
        System.out.println(bs.getByYearOfPublishWithGroupingBy());

    }

}