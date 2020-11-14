package week03;

import java.util.Scanner;

public class ExceptionDemo {

    public static void main(String[] args) {
        // System.out.println(1/0); //Arithmetical

        String s = null;
//         System.out.println(s.toUpperCase()); // NullPointer

        int[]n = {1,2};

        // System.out.println(n[5]); //ArrayIndexOutOf..

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        int i = Integer.parseInt(line);

        // System.out.println(i); NumberFormatException..
    }
}
