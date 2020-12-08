package introinheritance;

import java.util.ArrayList;
import java.util.List;

public class Trainer extends Human {

    private List<Course>  courses = new ArrayList<>();

    public Trainer(String name, int age, List<Course> courses) {
        super(name, age);
        this.courses = courses;
    }



    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
