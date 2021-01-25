package iofilestest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    Library library = new Library();



    @TempDir
    Path tempDir;




    @Test
    public void testSave() throws IOException {

        library.add(new Book("Robinson Crusoe", "Defoe"));
        library.add(new Book("Egri csillagok", "Gárdonyi"));
        //library.add(new Book("Fekete város", "Jókai"));



        Path path = tempDir.resolve("konyvek.txt");

        library.saveBooks(path);

        List<String> books = Files.readAllLines(path);
        System.out.println(books.toString());

        assertEquals(2, books.size());

        Files.writeString(path, "Fekete város:Jókai", StandardOpenOption.APPEND);

        library.loadBooks(path);

        books = Files.readAllLines(path);
        System.out.println(books.toString());

        assertEquals(3, books.size());




    }




}