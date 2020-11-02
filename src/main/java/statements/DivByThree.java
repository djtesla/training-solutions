package statements;

import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Írj be egy egész számot, és megmondom, osztható-e hárommal: ");

        int num = scanner.nextInt();

        String valasz = num % 3 == 0 ? "Osztható bizony!" : "Hát nem éppen osztható cimbi.";

        System.out.println(valasz);
    }
}
