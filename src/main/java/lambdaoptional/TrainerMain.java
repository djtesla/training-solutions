package lambdaoptional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TrainerMain {



    public Optional<Trainer> findFirst (List<Trainer> trainers, Predicate<Trainer> predicate) {

        for (Trainer trainer : trainers) {
            if (predicate.test(trainer)) {
                return Optional.of(trainer);
            }
        }
        return Optional.empty();
    }



    public static void main(String[] args) {

        List<Trainer> trainers = Arrays.asList(new Trainer("Lacibé", Arrays.asList("Java", "Matek", "Töri")),
                new Trainer("Gézabá", Arrays.asList("JavaScript", "Zene", "Töri")),
                new Trainer("Irmanéni", Arrays.asList("Python", "Magyar", "Föci")),
                new Trainer("Pistabá", Arrays.asList("Java", "Matek", "Angol")));

        new TrainerMain().findFirst(trainers,
                trainer -> trainer.getName().contains("bá")).orElseThrow(()-> new IllegalArgumentException(""));

        Trainer focused = new TrainerMain().findFirst(trainers,
                trainer -> trainer.getName().contains("bá")).orElseGet(() -> new Trainer("Juci", null));


















    }
}
