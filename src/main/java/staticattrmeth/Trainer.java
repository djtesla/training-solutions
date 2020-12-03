package staticattrmeth;

public class Trainer {

    public static int numberOfTrainers;

    private String name;

    public Trainer(String name) {
        this.name = name;
        numberOfTrainers++;
    }

    public String getName() {
        return name;
    }

    public static int getNumberOfTrainers() {
        return numberOfTrainers;
    }
}
