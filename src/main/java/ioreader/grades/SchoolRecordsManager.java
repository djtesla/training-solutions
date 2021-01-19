package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }



    public void readGradesFromFile(String fileName) {

        Path path = Path.of("grades.txt");

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;

            while ((line = reader.readLine()) != null) {
                students.add(newStudentByLine(line));
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

    }



    public Student newStudentByLine(String line){

        String[] studentData = line.split(" ");

       String studentName = studentData[0];
       List<Integer> marks = new ArrayList<>();

       for (int i = 1; i<studentData.length; i++) {
           marks.add(Integer.parseInt(studentData[i]));
       }

        return  new Student(studentName, marks);
    }



    public double classAverage(){

        double  sum = 0;

        for (Student student : students) {
            sum += student.average();
        }
        return sum / students.size();
    }
}
