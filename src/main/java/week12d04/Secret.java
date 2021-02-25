package week12d04;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Secret {

    public String printSecret(Path path) {

        StringBuilder sb = new StringBuilder();

        try {
            byte[] bytes = Files.readAllBytes(path);
                for (byte b : bytes) {
                    char c = (char) (b + 10);
                    sb.append(sb);
                }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
            }

        return sb.toString();
    }



}
