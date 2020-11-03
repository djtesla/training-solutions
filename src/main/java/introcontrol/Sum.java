package introcontrol;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        for (int i = 1; i < 6; i++) {

            System.out.println("Add meg az " + i + ". számot: ");
            int szam = scanner.nextInt();

            sum = sum + szam;

        }
        System.out.println("A beírt számok összege: " + sum + ".");
    }
}
