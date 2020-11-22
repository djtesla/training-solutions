package schoolrecords;

import java.util.*;

public class SchoolRecordsController {

    private ClassRecords classRecords = new ClassRecords("Fourth Grade A", new Random(5));
    private List<Subject> subjects = new ArrayList<>();
    private List<Tutor> tutors = new ArrayList<>();

    public ClassRecords getClassRecords() {
        return classRecords;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<Tutor> getTutors() {
        return tutors;
    }


    public Subject getSubjectByName (String name) {
        for (Subject subject : getSubjects()) {
            if (subject.getName().equals(name)) {
                return subject;
            }
        }
        throw new IllegalArgumentException("invalid subject");
    }


    public Tutor getTutorByName (String name) {
        for (Tutor tutor : getTutors()) {
            if (tutor.getName().equals(name)) {
                return tutor;
            }
        }
        throw new IllegalArgumentException("invalid subject");
    }


    public MarkType getMarkTypeByValue (int value) {
        for (MarkType markType : MarkType.values()) {
            if (markType.getValue() == value) {
                return markType;
            }
        }
        throw  new IllegalArgumentException("mark must be between 1 and 5");
    }



    public void initSchool() {


        subjects.add(new Subject("matematika"));
        subjects.add(new Subject("földrajz"));
        subjects.add(new Subject("történelem"));
        subjects.add(new Subject("magyar"));
        subjects.add(new Subject("kémia"));
        subjects.add(new Subject("fizika"));
        subjects.add(new Subject("biológia"));
        subjects.add(new Subject("testnevelés"));
        subjects.add(new Subject("angol"));
        subjects.add(new Subject("német"));
        subjects.add(new Subject("technika"));
        subjects.add(new Subject("ének"));

        tutors.add(new Tutor("Nagy Csilla",
                Arrays.asList(new Subject("földrajz"),
                        new Subject("biológia"))));

        tutors.add(new Tutor("Sramek Antal",
                Arrays.asList(new Subject("kémia"),
                        new Subject("fizika"))));

        tutors.add(new Tutor("Magyar Zoltán",
                Arrays.asList(new Subject("magyar"),
                        new Subject("matematika"))));

        tutors.add(new Tutor("Vida Viktor",
                Arrays.asList(new Subject("történelem"),
                        new Subject("matematika"))));

        tutors.add(new Tutor("Andy Crowe",
                Arrays.asList(new Subject("angol"),
                        new Subject("testnevelés"))));

        tutors.add(new Tutor("Vida Viktor",
                Arrays.asList(new Subject("ének"),
                        new Subject("angol"))));

        tutors.add(new Tutor("Vida Viktor",
                Arrays.asList(new Subject("német"),
                        new Subject("technika"))));


    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SchoolRecordsController controller = new SchoolRecordsController();

        controller.initSchool();

        int i = 0;

    do {
        System.out.println('\n' + "1. Diákok nevének listázása" + '\n' +
        "2. Diák név alapján keresése" + '\n' +
        "3. Diák létrehozása" + '\n' +
        "4. Diák név alapján törlése" + '\n' +
        "5. Diák feleltetése" + '\n' +
        "6. Osztályátlag kiszámolása" + '\n' +
        "7. Tantárgyi átlag kiszámolása" + '\n' +
        "8. Diákok átlagának megjelenítése" + '\n' +
        "9. Diák átlagának kiírása" + '\n' +
        "10. Diák tantárgyhoz tartozó átlagának kiírása" + '\n' +
        "11. Kilépés");

        i = Integer.parseInt(scanner.nextLine());

        switch (i) {

            case 1: {
                System.out.println(controller.classRecords.listStudentNames().toString());

                break;
            }

            case 2: {
                System.out.println("Kérem a diák nevét:");
                String name = scanner.nextLine();
                controller.classRecords.findStudentByName(name);
                break;
            }

            case 3: {
                System.out.println("Kérem a diák nevét:");
                String name = scanner.nextLine();
                controller.classRecords.addStudent(new Student(name));
            break;

            }
            case 4: {
                System.out.println("Kérem a diák nevét:");
                String name = scanner.nextLine();
                controller.classRecords.removeStudent(controller.classRecords.findStudentByName(name));
                break;
            }

            case 5: {
                Student looser = controller.classRecords.repetition();
                System.out.println(looser.getName() + " felel!");

                System.out.println("Kérem a jegyet:");
                int mark = Integer.parseInt(scanner.nextLine());

                System.out.println("Kérem a tárgy nevét:");
                String subjectName = scanner.nextLine();
                Subject repetitionSubject = controller.getSubjectByName(subjectName);

                System.out.println("Kérem az oktató nevét:");
                String tutorName = scanner.nextLine();
                Tutor repetitionTutor = controller.getTutorByName(tutorName);

                Mark repetitionMark = new Mark(controller.getMarkTypeByValue(mark), repetitionSubject, repetitionTutor);

                looser.grading(repetitionMark);

                break;


            }
            case 6: {
                System.out.println("Az osztályátlag: " + controller.classRecords.calculateClassAverage() + ".");

            }
            case 7: {

                String subjectName = scanner.nextLine();
                System.out.println(subjectName + " osztályátlag: " +
                        controller.classRecords.calculateClassAverageBySubject(controller.getSubjectByName(subjectName)) + ".");
                break;
            }
            case 8: {
                System.out.println(controller.classRecords.listStudyResults().toString());
                break;

            }
            case 9: {
                System.out.println("Kérem a diák nevét:");
                String name = scanner.nextLine();
                System.out.println(name + " átlaga: " + controller.classRecords.findStudentByName(name).calculateAverage() + ".");
                break;
            }
            case 10: {
                System.out.println("Kérem a diák nevét:");
                String name = scanner.nextLine();
                System.out.println("Kérem a tárgy nevét:");
                String subjectName = scanner.nextLine();
                System.out.println(name + " átlaga: " +
                        controller.classRecords.findStudentByName(name).calculateSubjectAverage(controller.getSubjectByName(subjectName)) + ".");
                break;
            }
            case 11: {
                System.out.println("Kiléptél.");
            }
        }

    } while (i != 11);


    }
}
