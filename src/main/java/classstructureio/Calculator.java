package classstructureio;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Írj egy egész számot: ");
                int szam1 = scanner.nextInt();
        System.out.println("Írj be egy másik egész számot: ");
        int szam2 = scanner.nextInt();
        System.out.println(szam1 + "+"+ szam2);
        System.out.println(szam1 + szam2);
    }
}
