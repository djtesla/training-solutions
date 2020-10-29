package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Írd be a nevedet: ");
        String nev = scanner.nextLine();
        System.out.println("Írd be az email címedet: ");
        String mail = scanner.nextLine();
        System.out.println(nev + " névvel és " + mail + " mail címnmel regisztráltál.");
    }
}
