package ioreadbytes.byteacount;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {


    public int readBytesAndFindAs(String file) {

        Path path = Path.of(file);

        int sum = 0;
        try (BufferedInputStream inputStream = new BufferedInputStream(Files.newInputStream(path))) {

            byte[] buffer = new byte[1000];

            int size;

            while ((size = inputStream.read(buffer)) > 0) {
                for (int i = 0; i < size; i++) {
                    if ((char) buffer[i] =='a') {
                        sum+=1;
                    }
                }
            }


        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

        return sum;


    }


}
