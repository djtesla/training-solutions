package week13d03;

public class Subject {

    private String teacherName;
    private String subjectName;
    private String className;
    private int lessons;

    public Subject(String teacherName, String subjectName, String className, int lessons) {

        this.teacherName = teacherName;
        this.subjectName = subjectName;
        this.className = className;
        this.lessons = lessons;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getClassName() {
        return className;
    }

    public int getLessons() {
        return lessons;
    }
}


    /*Mai Junior/Mid-level feladat (`week13d03`):
        Adott a következő szerkezetű fájl, beosztas.txt:
        Albatrosz Aladin
        biologia
        9.a
        2
        Albatrosz Aladin
        osztalyfonoki
        9.a
        1
        Csincsilla Csilla
        matematika
        9.b
        2
        A fájl tantárgyfelosztást tartalmaz. A tanttárgyfelosztást 4-es blokkokban adjuk meg.
         Első sor a tanár neve, majd a tantárgy, majd az osztály ahol tanítja és végül az, hogy heti hány órában.
         Írj egy metódust, ami paraméterül várja egy tanár nevét, és kiírja, hogy hány órája van egy héten. (edited)
        beosztas.txt
        Albatrosz Aladin
        biologia
        9.a
        2
        Albatrosz Aladin
        Click to expand inline (1,316 lines)


        :grinning:
        2





        9 replies
        Last reply today at 12:47 PMView thread

        Kristóf Bárczay  7:58 AM
        Ide várom a Junior/Mid-level kérdéseket!


        11 replies
        Last reply today at 11:10 AMView thread

        Viczián István  8:34 AM
        Korán röpködnek ma a feladatok. Senior feladat:
        Legyen egy Book osztály, melynek van egy String author, String title és int numberOfPages attribútuma.
        Írj egy másik osztályban egy olyan metódust, mely visszaadja a legtöbb oldalt
        író szerzőt! Figyelj arra, hogy hatékony legyen az algoritmus!*/