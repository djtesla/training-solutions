package defaultconstructor.date;

public class SimpleDate {

    private int year;
    private int month;
    private int day;


    public void setDate(int year, int month, int day) {

        if (isCorrect(year, month, day)) {

            this.year = year;
            this.month = month;
            this.day = day;
        }


    }


    private boolean isCorrect(int year, int month, int day) {

        return true;
    }


    private boolean isLeapYear(int year) {

        return true;
    }


    private int calculateMonthLength(int year, int month) {

        return 0;
    }



}
