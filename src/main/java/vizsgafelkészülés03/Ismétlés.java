package vizsgafelkészülés03;

public class Ismétlés {

    public static final double BOX_WEIGTH = 2.3;


    public void play(short a) {

        System.out.println("short a!");

    }     // 1
    public static void play(long a) {
        System.out.println("long a!");

    }       // 2
    public static void play(Integer a) {
        System.out.println("Integer a!");

    }   // 3
    public static void play(String... a) {
        System.out.println("String... a!");

    } // 4
    public static void play(String a, String b) {
        System.out.println("String a, String b!");

    } // 5

    public static void main(String[] args) {


    short x = 3;
    //play(4);
   //play(x);
    play("Hello");
    //play("alma", "körte");

}

}
