package constructoroverloading;

public class SimpleTime {

    private int hours;
    private int minutes;


    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public SimpleTime(int hours, int minutes) {
        this(hours);
        this.minutes = minutes;

    }


    public SimpleTime(int hours) {
        this.hours = hours;

    }


    public SimpleTime(SimpleTime time) {
        hours = time.hours;
        minutes = time.minutes;

    }

    public int difference(SimpleTime time) {
        return (hours * 60 + minutes) - (time.hours * 60 + time.minutes);

    }

    @Override
    public String toString() {
        return hours +":"+ minutes;
    }
}
