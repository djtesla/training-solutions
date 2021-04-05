package lambdaoptional;

import java.util.List;

public class Trainer {

    private String name;
    private List<String> subjects;


    public Trainer(String name, List<String> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<String> getSubjects() {
        return subjects;
    }
}

