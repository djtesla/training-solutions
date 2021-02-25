package exceptionresource.trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class TrainerReader {

    public static final String SEPARATOR = ";";

    private String values;

    public TrainerReader(String values)  {
        this.values = values;
    }


    public List<Trainer> read () throws IOException {

        List<Trainer> trainers = new ArrayList<>();
        String line;


        try (BufferedReader reader = new BufferedReader(new StringReader(values))) {
            while ((line = reader.readLine()) != null) {
                Trainer trainer = parseLine(line);
                trainers.add(trainer);
            }
        }

        catch (IOException ioe) {
            throw new IllegalArgumentException("Error by parsing, general io", ioe);
        }

        return trainers;
    }

    public Trainer parseLine (String line) {

        String[] fields = line.split(SEPARATOR);

        return new Trainer(fields[0], Integer.parseInt(fields[1]));


    }

    public static void main(String[] args) {

    }

}
