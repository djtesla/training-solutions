package controlselection.greetings;

public class Greetings {

    public String getGreeting (int hour, int minute) {

        if (hour < 5) {
            return "Good Night";
        } else if (hour < 10) {
            return "Good Morning";
        } else if (hour < 18 || hour == 18 && minute < 31) {
            return "Good Day";
        } else if (hour < 20) {
            return "Good Evening";
        } else if (hour < 24 || hour == 24 && minute == 0 ) {
            return "Good Night";
        }

        return "Amit Te beírtál, az nem nyerő. Egy nap 24 órából áll, tudtad?";

    }



    public static void main(String[] args) {
        Greetings greetings = new Greetings();

        System.out.println(greetings.getGreeting(3,20));

        System.out.println(greetings.getGreeting(18,30));

        System.out.println(greetings.getGreeting(18,31));

        System.out.println(greetings.getGreeting(64,20));


    }
}
