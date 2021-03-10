package week16d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class VowelFilter {

    public static final List<Character> VOWELS = List.of('a', 'á', 'e', 'é', 'i', 'í', 'o', 'ó', 'ö', 'ő', 'u', 'ú', 'ü', 'ű');



    public String filterVowels(BufferedReader reader) {

        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String filteredStr = getFilteredStrPerLine(line);
                sb.append(filteredStr + '\n');
            }
            return sb.toString();
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    private String getFilteredStrPerLine(String line) {
        StringBuilder sb = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (!VOWELS.contains(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        try(BufferedReader reader = Files.newBufferedReader(Path.of("gyakfiles/vowelfilter.txt"))) {

            System.out.println(new VowelFilter().filterVowels(reader));

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }



    }


}
