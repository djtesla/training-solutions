package finalmodifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week {

    /*
    public List<String> WEEKDAYS = new ArrayList<>();

    public static void main(String[] args) {
    Week week = new Week();

    week.WEEKDAYS.add("Hétfő");
    week.WEEKDAYS.add("Kedd");
    week.WEEKDAYS.add("Szerda");


        System.out.println(week.WEEKDAYS);

        week.WEEKDAYS.set(1, "Szerda");
        System.out.println(week.WEEKDAYS);

    }

    public static final List<String> WEEKDAYS = Arrays.asList("Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek");

    public static void main(String[] args) {

        WEEKDAYS.set(1, "Kabbe");

        System.out.println(WEEKDAYS);
*/
        public static final List<String> DAYS = Arrays.asList("Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap");


        public static void main(String[] args) {
            DAYS.set(1, "Szerda");
            System.out.println(DAYS);

            List<String> days2 = new ArrayList<>();
            days2.add("Monday");
            days2.add("Tuesday");
            days2.add("Wednesday");

            // DAYS = days2;

        }
    }
