package statements;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public int getInMinutes () {
    return hour * 60 + minute;
    }

    public int getInSeconds () {
        return hour * 3660 + minute * 60 + second;
    }

    public boolean earlierThan (Time time) {
        return this.getInSeconds() < time.getInSeconds();
    }

    public String toString () {
        return hour + ":" + minute + ":" + second;
    }
}
