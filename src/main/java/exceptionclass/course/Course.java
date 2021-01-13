package exceptionclass.course;

public class Course {

    private String name;
    private SimpleTime begin;

    public Course(String name, SimpleTime begin) {


        if (begin == null || name == null || "".equals(name)) {
            throw new IllegalArgumentException ("Parameters cannot be null or empty");
        }

        this.name = name;
        this.begin = begin;
    }

    public String getName() {
        return name;
    }

    public SimpleTime getBegin() {
        return begin;
    }

    @Override
    public String toString() {
        return begin.toString() + ": " + name;
    }
}
