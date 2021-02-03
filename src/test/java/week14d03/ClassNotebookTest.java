package week14d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassNotebookTest {

    @Test
    public void addMarkTest () {

        Student s= new Student("Sanyi");
        Student j = new Student("Jani");
        Student k = new Student("Kari");

        List<Student> students = List.of(s, j, k);

        s.enterNewMark("matematika", 3);
        s.enterNewMark("ének", 2);
        s.enterNewMark("filozófia", 4);

        j.enterNewMark("matematika", 5);
        j.enterNewMark("magyar", 5);
        j.enterNewMark("matematika", 4);

        k.enterNewMark("angol", 1);
        k.enterNewMark("matematika", 3);
        k.enterNewMark("tesi", 2);

        ClassNotebook cn = new ClassNotebook(students);

        cn.sortNotebook().get(0).enterNewMark("biológia", 2);


        System.out.println(cn.sortNotebook());

    }



}