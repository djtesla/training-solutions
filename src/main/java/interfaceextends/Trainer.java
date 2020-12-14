package interfaceextends;

public class Trainer implements HasNameAndAge{

    private String name;

    private int age;

    public Trainer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }
}
