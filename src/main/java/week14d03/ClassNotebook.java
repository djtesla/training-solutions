package week14d03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ClassNotebook {

    private List<Student> students;


    public ClassNotebook(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }



    public List<Student> sortNotebook () {
        List<Student> sortedStudents =new ArrayList<>();
                for (Student student : students) {
                    sortedStudents.add(new  Student(student));
                }

        Collections.sort(sortedStudents);
        return sortedStudents;
    }



}


   /*    Mai junior/mid-level feladat
    Készíts egy diák (`Student`) osztályt melyben egy diák jegyeit tárolod egy Map-ben.
    A map kulcsa a tantárgy, értéke pedig az adott tantárgy jegyeinek listája.
    Ezen felül a diáknak legyen neve, melyet konstruktorban kap meg.
    Legyen benne egy metódus, ami paraméterül vár egy tantárgyat és egy jegyet, és beírja a jegyet a megfelelő tantárgyhoz.
    Készítsd el a `ClassNotebook` nevű osztályt melyben diákok listája található. Készíts egy lekérdező metódust a
    `ClassNoteBook` osztályban, legyen a neve `sortNotebook` mely a diákok listáját ABC sorrendben adja vissza.*/

