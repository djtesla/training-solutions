package introinheritance;

import java.util.ArrayList;
import java.util.List;


public class Trainer extends Human {

    private String name;

    private List<Course> courses = new ArrayList<>();


    public Trainer(String name, int age, List<Course> courses) {
        super(name, age);
        this.courses = courses;

    }

    public Trainer(String name) {

        this.courses = courses;

    }


    public List<Course> getCourses() {

        return courses;
    }

    public void setCourses(List<Course> courses) {

        this.courses = courses;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getFreeTime() {
        return super.getFreeTime() - courses.size();
    }

    @Override
    public String toString() {

        return super.getName();
    }

    @Override
    public void work() {
        System.out.println("hello");
    }

    public static void main(String[] args) {

        Human trainer = new Trainer("", 2, null);

        trainer.work();





    }


}
