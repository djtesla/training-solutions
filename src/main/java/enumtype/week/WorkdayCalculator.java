package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {

    public List<DayType> dayTypes(Day firstDay, int numberOfDays) {
        List<DayType> dayType = new ArrayList<>();
        int i = 0;

        Day[] days = Day.values();
        for (Day day : days) {
            if (day.name().equals(firstDay.name())) {
                i = day.ordinal();

                for (int j = i; j <= i + numberOfDays; j++) {
                    dayType.add(days[j].getDayType());
                }

            }

        }
        return dayType;
    }

    private void nextDay(Day day) {


    }


}



