package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {
    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
        //this.students = students;
    }

    public String getClassName() {

        return className;
    }

    public int getRnd() {
        return rnd.nextInt();
    }

    public List<Student> getStudents() {

        return students;
    }


    public boolean addStudent(Student studentToBeAdded) {
        for (Student student: students){
            if (student.getName().equals(studentToBeAdded.getName())) {
                return false;
            }
        }
        students.add(studentToBeAdded);
        return true;
    }


    public boolean removeStudent(Student studentToBeRemoved) {
        for (Student student: students){
            if (student.getName().equals(studentToBeRemoved.getName())) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }



    public double calculateClassAverage() {

        int i = 0;
        int sum = 0;

        if (students.size() == 0) {
            throw new ArithmeticException ("No student in the class, average calculation aborted!");
        }
        for (Student student : students) {

            for (Mark mark: student.getMarks()){
                sum += mark.getMarkType().getValue();
                i++;
                }
        }
        if (i == 0) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }

            return (double) Math.round(100 * sum / i) / 100;
    }


    public double calculateClassAverageBySubject(Subject subject) {

        List<Mark> subjectMarks = new ArrayList<>();
        int i = 0;

        for (Student student : students) {

            for (Mark mark : student.getMarks()) {

                if (mark.getSubject().getName().equals(subject.getName())) {
                    subjectMarks.add(mark);
                }
            }
        }
        return getAverageOfMarks(subjectMarks);
    }



    public double getAverageOfMarks(List<Mark> marks) {

        int sum = 0;
        int i = 0;

        for (Mark mark: marks){
            sum += mark.getMarkType().getValue();
            i++;
        }
        return (double) Math.round(100 * sum / i) / 100;
    }


    public Student findStudentByName(String name) {
        if (students == null || students.size() == 0) {
            throw  new IllegalStateException ("No students to search!");
        }
        if (isEmpty(name)) {
            throw  new IllegalArgumentException ("Student name must not be empty!");
        }
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        throw new IllegalArgumentException ("Student by this name cannot be found! " + name);
    }



    public boolean isEmpty(String name) {
        return (name == null || name.equals(""));
    }



  public Student repetition () {

        if (students.size() == 0) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        int i =rnd.nextInt(students.size());
        return students.get(i);
        }



    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> studyResults = new ArrayList<>();
        for (Student student: students){
            studyResults.add(new StudyResultByName(student.getName(), student.calculateAverage()));
        }
        return studyResults;
    }


    public String listStudentNames() {
        String studentNames = "";
        for (Student student: students) {
            studentNames += student.getName() + ", ";
        }
        return studentNames.substring(0, studentNames.length()-2);
    }
}




