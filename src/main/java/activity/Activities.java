package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private List<Activity> activities;


    public Activities(List<Activity> activities) {
        this.activities = activities;
    }


    public void addActivity(Activity activity) {
        activities.add(activity);


    }

    public List<Report> distancesByTypes() {

        List<Report> distancesByTypesReport = new ArrayList<>();


        ActivityType[] activityTypes = ActivityType.values();

        for (ActivityType activityType : activityTypes) {

            double distance = getDistanceByType(activityType);


                distancesByTypesReport.add(new Report(activityType, distance));


        }
        return distancesByTypesReport;
    }



    public double getDistanceByType(ActivityType activityType) {

        double distanceByType = 0;

        for (Activity activity : activities) {

            if (activity.getType() == activityType) {
                distanceByType += activity.getDistance();
            }
        }
        return distanceByType;
    }



    public int numberOfTrackActivities() {

        int sum = 0;

        for (Activity activity : activities) {
            if (activity instanceof ActivityWithTrack) {
                sum += 1;
            }
        }

        return sum;
    }


    public int numberOfWithoutTrackActivities() {

        int sum = 0;

        for (Activity activity : activities) {
            if (activity instanceof ActivityWithoutTrack) {
                sum += 1;
            }
        }

        return sum;
    }
}
