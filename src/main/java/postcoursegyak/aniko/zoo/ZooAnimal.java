package postcoursegyak.aniko.zoo;

public class ZooAnimal{

    private String name;
    private double length;
    private double weight;


    public ZooAnimal(String name) {
        this.name = name;
    }

    public ZooAnimal(String name, double length) {
        this.name = name;
        this.length = length;
    }

    public ZooAnimal(String name, double length, double weight) {
        this.name = name;
        this.length = length;
        this.weight = weight;
    }


    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

}
