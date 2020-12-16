package polymorphysm;

import interfaces.HasName;

public class Course implements HasName {

    public Course(String name) {
        this.name = name;
    }

    String name;

    @Override
    public String getName() {
        return name;
    }
}
