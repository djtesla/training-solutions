package gyakorlás;


import java.util.Scanner;

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


    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            scanner = new Scanner(GyakokMain.class.getResourceAsStream("numbers.txt"));
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                int number = Integer.parseInt(line);
                System.out.println(number);
            }
        }

        catch (NumberFormatException nfe) {
            //System.out.println("Invalid number");
            throw new IllegalArgumentException("Invalid number", nfe);
        }

        catch (NullPointerException npe) {
            //System.out.println("File not found");
            throw npe;
        }

        finally {
            if (scanner != null) {
            scanner.close();
            }
        }






    }
}











