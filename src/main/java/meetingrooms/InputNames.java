package meetingrooms;

import java.util.Scanner;

public class InputNames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));

        String[] names = new String [5];

        for (int j = 0; j < 5; j++ ) {
            System.out.println("Kérem a(z) " + (j +1) + ". nevet: ");
            names[j] = scanner.nextLine();

        }

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}
