package introconstructors;

import java.time.LocalDateTime;

public class Tasks {

    String title;
    String description;
    LocalDateTime startDateTime;
    int duration;

    public Tasks(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {

        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration (int duration) {

        this.duration = duration;
    }

    public void start () {

        startDateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDateTime=" + startDateTime +
                ", duration=" + duration +
                '}';
    }

    public static void main(String[] args) {

        Tasks task = new Tasks("Megvenni a kólát", "Elmenni a Lidliig és vásárolni");
        task.start();
        task.setDuration(1);

        System.out.println(task);
    }

}




