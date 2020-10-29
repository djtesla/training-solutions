package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Írd be a a nevedet: ");
        client.name = scanner.nextLine();
        System.out.println("Írd be a a születési évedet: ");
        client.birthDate = scanner.nextInt();
        System.out.println("Írd be a a címedet:");
        client.address = scanner.nextLine();

        System.out.println(client.name);
        System.out.println(client.birthDate);
        System.out.println(client.address);
    }
}
