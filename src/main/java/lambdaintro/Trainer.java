package lambdaintro;

public class Trainer {

    private String name;
    private int age;

    public Trainer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static int compareTrainerByNameThenAge (Trainer trainer1, Trainer trainer2) {
        if (trainer1.getName().equals(trainer2.getName())) {
            return trainer1.getAge()-trainer2.getAge();
        }
        return trainer1.getName().compareTo(trainer2.getName());
    }
}