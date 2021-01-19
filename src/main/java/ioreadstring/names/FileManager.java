package ioreadstring.names;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private Path myFile;
    private List<Human> humans = new ArrayList<>();


    public FileManager(String myFilePath) {
        this.myFile = Path.of(myFilePath);
    }


    public Path getMyFile() {
        return myFile;
    }


    public List<Human> getHumans() {
        return humans;
    }


    public void readFromFile() {


        Path path = Path.of("names.txt");

        List<String> names = null;

        try {
            names = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

        for (String name : names){
            String[] nameArr = name.split(" ");
            humans.add(new Human(nameArr[0], nameArr[1]));
        }

        System.out.println(humans);

    }
}
