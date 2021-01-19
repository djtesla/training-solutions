package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Register {


    public void newMark(Path file, int mark) {


        try {
            if (Files.exists(file)) {
                Files.writeString(file, mark + "\n", StandardOpenOption.APPEND);
            } else {
                Files.writeString(file, Integer.toString(mark));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }


    public void average(Path fileName) {
        List<String> allMarks = null;

        try {
            allMarks = Files.readAllLines(fileName);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

        double sum  = 0;
        for (String mark : allMarks) {
            sum += Double.parseDouble(mark);
        }

        try {
            Files.writeString(fileName, "average: " + sum / allMarks.size(), StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }
}
