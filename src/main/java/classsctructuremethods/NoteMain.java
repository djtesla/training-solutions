package classsctructuremethods;

public class NoteMain {
    public static void main(String[] args) {
        Note note = new Note();
        note.setName("Todos");
        note.setTopic("Weekend");
        note.setText("Learning");

        System.out.println(note.getNoteText());
    }

}
