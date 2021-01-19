package ioreader.states;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {

    private List<State> states = new ArrayList<>();

    public List<State> getStates() {
        return new ArrayList<>(states);
    }


    public void readStatesFromFile(String fileName) {

        Path path = Path.of(fileName);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                states.add(newStateByLine(line));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);

        }

    }


    public String findCapitalByStateName(String stateName) {

        for (State state : states) {
            if (state.getStateName().equals(stateName)) {
                return state.getCapital();
            }
        }
        throw new IllegalArgumentException("No state with this name!");
    }



    public State newStateByLine(String line) {

        String[] stateData = line.split("-");

        return new State(stateData[0], stateData[1]);
    }
}
