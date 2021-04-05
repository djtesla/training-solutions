package lambdaintro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class TrainerMain {


    public Trainer findfirst(List<Trainer> trainers, Predicate<Trainer> condition) {
        for (Trainer trainer : trainers) {
            if (condition.test(trainer)) {
                return trainer;
            }
        }
        throw new IllegalArgumentException("Cannot find trainer");
    }




    public static void main(String[] args) {
        List<Trainer> trainers = new ArrayList<>();

        trainers.add(new Trainer("Joci", 10));
        trainers.add(new Trainer("Béci",6));
        trainers.add(new Trainer("Smuci",22));
        trainers.add(new Trainer("Józsi",4));


        trainers.sort(Comparator.comparing(Trainer::getName));

        trainers.sort((trainer1, trainer2)-> Trainer.compareTrainerByNameThenAge(trainer1, trainer2));
        trainers.sort(Trainer::compareTrainerByNameThenAge);


    }





}
