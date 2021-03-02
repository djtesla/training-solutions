package activitytracker2;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

public class TrackPoint {


    private LocalDate time;
    private double lat;
    private double lon;

    public TrackPoint(LocalDate time, double lat, double lon) {
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public LocalDate getTime() {
        return time;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return
                "time=" + time +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
