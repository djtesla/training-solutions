package classsctructureintegrate;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Termék neve: ");
        String name = scanner.nextLine();

        System.out.println("Termék ára: ");
        int price = scanner.nextInt();

        Product product = new Product(name, price);

        System.out.println("Termék beállított neve: " + product.getName());
        System.out.println("Termék kezdeti ára (Ft): " + product.getPrice());

        System.out.println("Mennyivel növeljem a termék árát?" + "(Kezdeti ár: " + product.getPrice() + " Ft)");
        int amount = scanner.nextInt();
        product.increasePrice(amount);
        System.out.println("A termék ára a növelés után: " + product.getPrice() + " Ft");

        System.out.println("Mennyivel csökkentsem a termék árát?" + "(Jelenlegi ár: " + product.getPrice() + " Ft)");
        amount = scanner.nextInt();
        product.increasePrice(amount);
        System.out.println("A termék ára a csökkentés után: " + product.getPrice() + " Ft");
    }

}
