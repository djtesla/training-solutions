package activitytracker2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Activity {

    private long id;
    private LocalDateTime startTime;
    private String desc;
    private ActivityType type;
    private List<TrackPoint> trackPoints = new ArrayList<>();

    public Activity(long id, LocalDateTime startTime, String desc, ActivityType type, List<TrackPoint> trackPoints) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
        this.trackPoints = trackPoints;
    }

    public Activity(LocalDateTime startTime, String desc, ActivityType type, List<TrackPoint> trackPoints) {
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
        this.trackPoints = trackPoints;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDesc() {
        return desc;
    }

    public ActivityType getType() {
        return type;
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void addTrackPointList(List<TrackPoint> trackPointsList) {
        for (TrackPoint trackPoint : trackPointsList) {
            trackPoints.add(trackPoint);
        }
    }

    @Override
    public String toString() {
        return "id=" + id + ", startTime=" + startTime +
                ", desc='" + desc + '\'' + ", type=" + type +
                ", trackPoints=" + trackPoints + '\n';

    }
}
