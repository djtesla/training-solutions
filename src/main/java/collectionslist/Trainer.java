package collectionslist;

import java.util.*;

public class Trainer {

    private String name;

    public Trainer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return name.equals(trainer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static void main(String[] args) {
        List<String> names = new LinkedList<>();
        Collection c = names;
        c.add("Géza");
        c.add("Miki");
        c.add("Géza");
        c.add("Miki");
        names.add(1, "Béci");
        names.remove(1);
        names.set(3, "Brenő");
        Set<Trainer> trainers = new LinkedHashSet<>();
        trainers.add(new Trainer("Géza"));
        trainers.add(new Trainer("Béci"));
        trainers.add(new Trainer("Jóska"));
        trainers.add(new Trainer("Manó"));
        trainers.add(null);
        System.out.println(trainers);
    }
}