package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {

    private String name;
    private List<Subject> subjects = new ArrayList<>();

    public Tutor(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }


    public boolean tutorTeachingSubject(Subject subjectToCheck) {
        for (Subject subject: subjects) {
            if (subjectToCheck.getName().equals(subject.getName())) {
                return true;
            }
        }
        return false;
    }
}
