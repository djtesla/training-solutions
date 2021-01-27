package week13d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SubjectManager {

    private List<Subject> subjects = readFromFile();


    public List<Subject> readFromFile() {

        List<Subject> subjects = new ArrayList<>();

        Path path = Path.of("beosztas.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String teacherName;
            while ((teacherName = reader.readLine()) != null) {
                String subjectName = reader.readLine();
                String className = reader.readLine();
                int lessons = Integer.parseInt(reader.readLine());
                subjects.add(new Subject(teacherName, subjectName, className, lessons));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        return subjects;
    }


    public int getLessonsByName(String name) {
        int l = 0;
        for (Subject subject : subjects) {
            if (subject.getTeacherName().equals(name)) {
                l += subject.getLessons();
            }
        }
        return l;
    }


}
