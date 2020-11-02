package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Első időpont óra:");
        int hour = scanner.nextInt();
        System.out.println("Első időpont perc:");
        int minute = scanner.nextInt();
        System.out.println("Első időpont másodperc:");
        int second = scanner.nextInt();
        Time time = new Time(hour, minute, second);

        System.out.println("Második időpont óra:");
        hour = scanner.nextInt();
        System.out.println("Második időpont perc:");
        minute = scanner.nextInt();
        System.out.println("Második időpont másodperc:");
        second = scanner.nextInt();
        Time anotherTime = new Time(hour, minute, second);

        System.out.println(time.toString());
        System.out.println(time.getInMinutes());
        System.out.println(anotherTime.toString());
        System.out.println(anotherTime.getInSeconds());

        System.out.println(time.earlierThan(anotherTime));
    }
}
