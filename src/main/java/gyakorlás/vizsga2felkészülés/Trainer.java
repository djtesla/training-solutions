package gyakorlás.vizsga2felkészülés;

import gyakorlás.TrafficLight;

import java.util.ArrayList;
import java.util.List;

public class Trainer extends Human {

    private String name;
    private List<Course> courses = new ArrayList<>();


    public Trainer() {
    }

    @Override
    public String getName() {
        return name;
    }


    public Trainer(String name, int age, List<Course> courses) {

        this.courses = courses;
    }


    public List<Course> getCourses() {
        return courses;
    }

    public void sayHello() {

        System.out.println("Hello");
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    @Override
    public int getFreeTime() {
        return 5;
    }
}
