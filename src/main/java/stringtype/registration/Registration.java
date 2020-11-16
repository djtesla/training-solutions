package stringtype.registration;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserValidator uservalidator = new UserValidator();

        System.out.println("Kérem a felhasználó nevet: ");
        String name = scanner.nextLine();
        System.out.println(uservalidator.isValidUsername(name) ? "Helyesen megadtad a felhasználónevet." : "Nem adtál meg felhasználónevet");

        System.out.println("Kérem az emailt: ");
        String email = scanner.nextLine();
        uservalidator.isValidUsername(name);
        System.out.println(uservalidator.isValidEmail(email) ? "Helyes email címet adtál meg" : "Nem adtál meg helyes email címet.");

        System.out.println("Kérem a jelszót: ");
        String password1 = scanner.nextLine();
        System.out.println("Kérem a jelszót mégegyszer: ");
        String password2 = scanner.nextLine();
        System.out.println(uservalidator.isValidPassword(password1, password2) ? "A két jelszó megegyezik." : "Állj állj! A két jelszó nem egyezik meg, vagy túl rövid!");
    }
}
