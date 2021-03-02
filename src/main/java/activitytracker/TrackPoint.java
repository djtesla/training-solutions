package activitytracker;

import java.time.LocalDate;

public class TrackPoint {

    private long id;
    private LocalDate time;
    private double lat;
    private double lon;
    private long activity_id;

    public TrackPoint(LocalDate time, double lat, double lon, long activity_id) {
        this.time = time;
        this.lat = lat;
        this.lon = lon;
        this.activity_id = activity_id;
    }

    public TrackPoint(LocalDate time, double lat, double lon) {
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public TrackPoint(long id, LocalDate time, double lat, double lon) {
        this.id = id;
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public TrackPoint(long id, LocalDate time, double lat, double lon, long activity_id) {
        this.id = id;
        this.time = time;
        this.lat = lat;
        this.lon = lon;
        this.activity_id = activity_id;
    }

    public long getId() {
        return id;
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

    public long getActivity_id() {
        return activity_id;
    }
}
