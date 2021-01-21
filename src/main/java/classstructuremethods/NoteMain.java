package classstructuremethods;

import java.util.Scanner;

public class NoteMain {
    public static void main(String[] args) {
        Note note = new Note();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Note neve:");
        String name = scanner.nextLine();

        System.out.println("Note témája:");
        String topic = scanner.nextLine();

        System.out.println("Note szövege:");
        String text = scanner.nextLine();

        note.setName(name);
        note.setTopic(topic);
        note.setText(text);

        System.out.println(note.getNoteText());
    }

}
