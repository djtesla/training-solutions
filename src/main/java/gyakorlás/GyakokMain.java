package gyakorlás;



public class GyakokMain {



    public static void play(short a) {
    }     // 1

         // 2


    public static void play(String... a) {
    } // 4

    public static void play(String a, String b) {
    } // 5

    public static void play(int...i) {
    } // 5


    public void main(String[] args) {


        short x = 3;
        play(4);
        play(x);
        play("Hello");
        play("alma", "körte");

    }
}











