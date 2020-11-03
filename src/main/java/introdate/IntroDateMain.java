package introdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class IntroDateMain {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2000, Month.JANUARY, 10);
        System.out.println(date);

        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalTime time = LocalTime.of(2,10);
        System.out.println(time);
        LocalDateTime dateTime = LocalDateTime.of(2000,1, 10, 2, 10);
        System.out.println(dateTime);
        LocalDate anotherDate = LocalDate.of(2000, 1, 10);
        System.out.println(date.equals(anotherDate));

    }

}
