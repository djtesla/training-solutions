package exceptionclass.course;

public class SimpleTime {

    private int hour;
    private int minute;

    public SimpleTime(int hour, int minute) {

        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }

        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }

        this.hour = hour;
        this.minute = minute;
    }


    public SimpleTime(String time) {

        int hour = 0;
        int minute = 0;

        try {
            String[] timeArr = time.split(":");

            hour = Integer.parseInt(timeArr[0]);
            minute = Integer.parseInt(timeArr[1]);

        } catch (NumberFormatException nfe) {
            throw new InvalidTimeException("Time is not hh:mm");

        } catch (NullPointerException npe) {
            throw new InvalidTimeException("Time is null");
        }


        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }

        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }

        this.hour = hour;
        this.minute = minute;
    }


    public int getHour() {
        return hour;
    }


    public int getMinute() {
        return minute;
    }


    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }


}
