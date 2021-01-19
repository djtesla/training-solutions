package ioreader.grades;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Integer> gradeList;


    public Student(String name, List<Integer> gradeList) {
        this.name = name;
        this.gradeList = gradeList;
    }


    public String getName() {
        return name;
    }

    public List<Integer> getGradeList() {
        return new ArrayList<>(gradeList);
    }



    public double average() {

        double sum = 0;
        for (int mark : gradeList) {
            sum += mark;
        }
        return sum / gradeList.size();
    }


    public boolean isIncreasing() {

        int previous = gradeList.get(0);

        for (int next : gradeList) {
            if (previous > next) {
                return false;
            }
            previous = next;
        }

        return true;
    }


}
