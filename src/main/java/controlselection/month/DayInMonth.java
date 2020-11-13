package controlselection.month;

public class DayInMonth {


    public int getDays(int year, String nameOfMonth) {

        int days= 0;

        switch (nameOfMonth.toLowerCase()) {

            case "április":
            case "június":
            case "szeptember":
            case "november":
                days = 30;
                break;

            case "január":
            case "március":
            case "május":
            case "július":
            case "augusztus":
            case "október":
            case "december":
                days = 31;
                break;

            case "február":
                if (isYearSpecial(year)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;

            default:
                throw new IllegalArgumentException("Invalid month: " + nameOfMonth);
        }

        return days;

    }

    public boolean isYearSpecial(int year) {

        return year % 4 == 0 && year % 100 !=0 || year % 4 == 0 && year % 400 == 0;
    }


    public static void main(String[] args) {

        DayInMonth dayInMonth = new DayInMonth();

        System.out.println(dayInMonth.getDays(2019,"február"));


    }
}
