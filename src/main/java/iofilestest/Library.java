package iofilestest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();

    public List<String> getBooks() {
        return new ArrayList(books);
    }


    public void add(Book bookToBeAdded) {

        for (Book book : books) {
            if (book.getTitle().equals(bookToBeAdded.getTitle()) &&
                    book.getAuthor().equals(bookToBeAdded.getAuthor())) {
                return;
            }
        }
        books.add(bookToBeAdded);
    }


    public void saveBooks(Path path) {

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Book book : books) {
                writer.write(book.getAuthor() + ":" + book.getTitle() + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }


    public void loadBooks(Path path) {

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(":");
                add(new Book(data[0], data[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }

    @Override
    public String toString() {
        return books.toString();
    }
}




