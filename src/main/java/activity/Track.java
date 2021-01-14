package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();


    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }


    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }


    public Coordinate findMaximumCoordinate() {

        double  maxLatitude = trackPoints.get(0).getCoordinate().getLatitude();
        double  maxLongitude = trackPoints.get(0).getCoordinate().getLongitude();

        for (TrackPoint trackPoint : trackPoints) {

            if (trackPoint.getCoordinate().getLatitude() > maxLatitude) {
                maxLatitude = trackPoint.getCoordinate().getLatitude();
            }

            if (trackPoint.getCoordinate().getLongitude() > maxLongitude) {
                maxLongitude = trackPoint.getCoordinate().getLongitude();
            }
        }

        return new Coordinate(maxLatitude, maxLongitude);
    }




    public Coordinate findMinimumCoordinate() {


        double  minLatitude = trackPoints.get(0).getCoordinate().getLatitude();
        double  minLongitude = trackPoints.get(0).getCoordinate().getLongitude();

        for (TrackPoint trackPoint : trackPoints) {

            if (trackPoint.getCoordinate().getLatitude() < minLatitude) {
                minLatitude = trackPoint.getCoordinate().getLatitude();
            }

            if (trackPoint.getCoordinate().getLongitude() < minLongitude) {
                minLongitude = trackPoint.getCoordinate().getLongitude();
            }
        }

        return new Coordinate(minLatitude, minLongitude);
    }




    public double getDistance() {

        double distance = 0;

        for (int i = 1; i < trackPoints.size(); i++ ) {
            distance += (trackPoints.get(i-1)).getDistanceFrom(trackPoints.get(i));
        }

        return distance;
    }



    public double getFullDecrease() {

        double decrease = 0;

        for (int i = 1; i < trackPoints.size(); i++) {

            if (trackPoints.get(i).getElevation() < trackPoints.get(i - 1).getElevation()) {
                decrease += trackPoints.get(i - 1).getElevation() - trackPoints.get(i).getElevation();
            }
        }
        return decrease;
    }


    public double getFullElevation() {

        double elevation = 0;

        for (int i = 1; i < trackPoints.size(); i++) {

            if (trackPoints.get(i).getElevation() > trackPoints.get(i - 1).getElevation()) {
                elevation += trackPoints.get(i).getElevation() - trackPoints.get(i - 1).getElevation();
            }
        }
        return elevation;
    }


    public double getRectangleArea() {

        double a = findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude();
        double b = findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude();

        return a * b;
    }

}
