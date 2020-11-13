package controlselection.week;

import java.util.Scanner;

public class DayOfWeeks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Írd be a hét napjának nevét: ");
        String day = scanner.nextLine();

        String reply = "";

        switch (day.toLowerCase()) {


            case "hétfő":
            reply ="hét eleje van";
                break;


            case "kedd":
            case" szerda":
            case" csütörtök":
                reply = "hét közepe van";
                break;

            case "péntek":
                reply="majdem hétvége";
                break;

            case "szombat":
            case "vasárnap":
                reply= "hétvége!";
                break;

                default:
                    throw new IllegalArgumentException("Invalid day: " + day);
        }

        System.out.println(reply);

    }
}
