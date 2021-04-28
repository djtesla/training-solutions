package postcoursegyak.aniko.zoo;

import java.util.*;
import java.util.stream.Collectors;

public class Zoo {

    private List<ZooAnimal> animals;

    public Zoo(List<ZooAnimal> animals) {
        this.animals = animals;
    }

    public List<ZooAnimal> getAnimals() {
        return animals;
    }

    public void addAnimal(ZooAnimal animal) {
        animals.add(animal);
    }

    public ZooAnimal getHeaviestAnimalInTheZoo() {

        Optional<ZooAnimal> animalWithMaxWeight = Optional.empty();
        double maxWeight = Double.MIN_VALUE;
        for (ZooAnimal animal : animals) {
            double weight = animal.getWeight();
            if (weight > maxWeight) {
                maxWeight = weight;
                animalWithMaxWeight = Optional.of(animal);
            }
        }
        if (animalWithMaxWeight.isPresent()) {
            return animalWithMaxWeight.get();
        }
        throw new IllegalStateException("animals is empty or null");
    }


    public Map<ZooAnimal, Integer> getAnimalStatistics() {
        Map<ZooAnimal, Integer> animalStat = new HashMap<>();
        for (ZooAnimal animal : animals) {
            if (!animalStat.containsKey(animal)) {
                animalStat.put(animal,1);
            } else {
                animalStat.put(animal,animalStat.get(animal)+1);
            }
        }
        return animalStat;
    }




    public ZooAnimal findExactAnimalByName(String name) {
        for (ZooAnimal animal : animals) {
            if (name.equals(animal.getName())) {
                return animal;
            }
        }
        throw new IllegalArgumentException("No animal exists with given name");
    }


    public List<ZooAnimal> getAnimalsOrderedByName() {
        List<ZooAnimal> copied = new ArrayList<>(animals);
         copied.sort(Comparator.comparing(ZooAnimal::getName));
         return copied;
    }



}
