package introcontrol;

import java.util.Scanner;

public class Qualifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Írj be egy számot: ");
        int num = scanner.nextInt();

        if (num > 100) {
            System.out.println("Nagyobb, mint száz.");

        } else {
            System.out.println("Kisebb, mint száz.");
        }
    }
}
