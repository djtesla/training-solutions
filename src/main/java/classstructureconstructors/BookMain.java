package classstructureconstructors;

import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg a könyv szerzőjét: ");
        String author = scanner.nextLine();
        System.out.println("Add meg a könyv címét: ");
        String title = scanner.nextLine();
        System.out.println("Add meg a regisztrációs számot: ");
        String regNumber = scanner.nextLine();

        Book book = new Book(author, title);
        book.register(regNumber);

        System.out.println(book.getAuthor() + ": " + book.getTitle() + ", reg. szám:" + book.getRegNumber());


    }
}
