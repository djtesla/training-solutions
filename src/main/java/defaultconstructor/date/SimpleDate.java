package defaultconstructor.date;

import java.time.LocalDate;

public class SimpleDate {

    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDate(int year, int month, int day) {

        if (isCorrect(year, month, day)) {

            this.year = year;
            this.month = month;
            this.day = day;
        }


    }


    private boolean isCorrect(int year, int month, int day) {

        if (
                        year < 1900 ||
                        month < 1 ||
                        month > 12 ||
                        calculateMonthLength(year, month) != day
        ) {

            throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
        }
        return true;
    }


    private int calculateMonthLength(int year, int month) {

        int length = 0;

        switch (month) {

            case 2:
                length = 28;
                if (LocalDate.of(year, 1, 1).isLeapYear()) {
                    length = 29;
                }
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                length = 30;
                break;

            default:
                length = 31;
        }

        return length;
    }


    private boolean isLeapYear(int year) {

        return true;
    }


}
