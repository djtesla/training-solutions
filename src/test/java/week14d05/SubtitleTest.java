package week14d05;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class SubtitleTest {

    public static final Path FILE = Path.of("hachiko.srt");

    Subtitle st = new Subtitle();

    @Test
    public void readFromClassPath() {
        try (InputStreamReader ir = new InputStreamReader(Subtitle.class.getResourceAsStream("/" + FILE.toString()))) {
            System.out.println(st.countWords(ir, "Hachiko", "haza", "pályaudvar", "jó"));

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }


    @Test
    public void readFromFileSystem() {
        try (FileReader fr = new FileReader(FILE.toFile(), Charset.forName("windows-1250"))) {
            System.out.println(st.countWords(fr, "Hachiko", "haza", "pályaudvar", "jó"));
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }


    }

}

