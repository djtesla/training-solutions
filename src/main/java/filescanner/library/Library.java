package filescanner.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }



    public void loadFromFile () {

        try(Scanner scanner = new Scanner(Library.class.getResourceAsStream("/src/test/books.csv"))) {

            scanner.useDelimiter(";|(\r\n)|\n");

            while (scanner.hasNextLine()) {

                String regNum = scanner.next();
                String author = scanner.next();
                String title = scanner.next();
                int yearOfPublish = scanner.nextInt();

                books.add(new Book(regNum, author, title, yearOfPublish));

            }
        }
        }



    public static void main(String[] args) {

        Library library = new Library();

        library.loadFromFile();

        System.out.println(library.getBooks());

    }
}
