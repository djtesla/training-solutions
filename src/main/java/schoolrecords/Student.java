package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(String name) {

        if (name.equals("")) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {

        String s = (name + " marks: " + marks.toString());
        s = s.replace("[","").replace("]","");
        return s;
        //return (subject.getName() + ": " + getMarkType().getDescription()+"(" + getMarkType().getValue()+")");
    }

    public void grading(Mark mark) {

        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    public double calculateAverage() {
        double sum = 0;
        double average = 0;
        for (Mark mark: marks) {
             sum +=mark.getMarkType().getValue();
        }
        average = (Math.round(sum / marks.size() * 100))/ 100D;
        return average;
    }


    public double calculateSubjectAverage(Subject subject) {
        int sum = 0;
        double average = 0;
        int i = 0;
        for (Mark mark: marks) {
            if (mark.getSubject() == subject) {
                sum += mark.getMarkType().getValue();
                i++;
                average = (double) sum / i;
            }
        }
        return average;
    }



}
