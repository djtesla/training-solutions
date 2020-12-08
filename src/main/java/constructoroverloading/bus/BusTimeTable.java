package constructoroverloading.bus;

import constructoroverloading.SimpleTime;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

    private List<SimpleTime> timeTable;


    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {

        timeTable = new ArrayList<>();

        SimpleTime firstTime = new SimpleTime(firstHour, everyMinute);

        int numberOfBuses = (lastHour - firstHour) * 60 / everyMinute - 1;

        for (int i = 1; i <= numberOfBuses; i++) {
            if (i == 1) {
                timeTable.add(firstTime);
            } else {

                firstTime = increaseTime(firstTime, everyMinute);
                timeTable.add(firstTime);
            }
        }

    }


    public SimpleTime increaseTime(SimpleTime actualTime, int minutes) {

        int increasedHours = actualTime.getHours();
        int increasedMinutes = actualTime.getMinutes();

        if (actualTime.getMinutes() + minutes > 59) {
            increasedHours += 1;
            increasedMinutes = minutes - (60 - actualTime.getMinutes());
        } else {
            increasedMinutes += minutes;
        }

        return new SimpleTime(increasedHours, increasedMinutes);

    }

    public List<SimpleTime> getTimeTable() {
        return timeTable;
    }
}


