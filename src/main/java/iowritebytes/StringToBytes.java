package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StringToBytes {


    public void writeAsBytes(List<String> lines, Path path) {

        try (OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(path))) {

            for (String line : lines) {
                if (line.startsWith("_")) {

                } else {
                    outputStream.write(line.getBytes());
                }
            }

        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot write file", ioe);
        }
    }

}


/*    Szövegek írása bájt tömbként
    Hozz létre egy StringToBytes osztályt és készíts benne egy writeAsBytes() metódust! A metódus a paraméterként
        kapott szöveg listából az "_" jellel kezdődő szövegeken kívül minden mást kiír a szintén paraméterül kapott path-ra bináris fájlba.*/
