package interfaces;

public class Course implements HasName {

    String name;

    @Override
    public String getName() {
        return name;
    }
}
