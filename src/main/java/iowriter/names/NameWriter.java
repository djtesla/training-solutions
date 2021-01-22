package iowriter.names;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NameWriter {

    private Path path;

    public NameWriter(Path path) {
        this.path = path;
    }




    public void addAndWrite(String name) {


        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {

            writer.write(name + "\n");

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }
}


/*Nevek
        Az első feladatban egyszerűen neveket fogunk eltárolni fájlban és listában egyaránt.
        A NameWriter osztály konstruktorban megkapja az írni kívánt fájlt. Az addAndWrite() metódus egy nevet vár paraméterül,
        amelyet hozzáfűzi a fájlhoz. A hozzáfűzéshez használd a korábban megismert StandardOpenOption.Append paramétert a
        newBufferedWriter() metódusban.*/
