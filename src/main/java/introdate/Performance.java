package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class Performance {
    private LocalDate date;
    private String artist;
    private LocalTime startTime;
    private LocalTime endtTime;


    public Performance(String artist, int year, int month, int day, int startHour, int startMinute, int endHour, int endMinute) {
        this.date = LocalDate.of(year, month, day);
        this.artist = artist;
        this.startTime = LocalTime.of(startHour, startMinute);
        this.endtTime = LocalTime.of(endHour, endMinute);
    }

    public String getInfo() {
        return artist + ": " + date + " " + startTime + " - " + endtTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getArtist() {
        return artist;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndtTime() {
        return endtTime;
    }
}
