package statements;

import java.util.Scanner;

public class InvestmentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Befektetés összege: ");
        int cost = scanner.nextInt();
        System.out.println("Tőke: ");
        int fund = scanner.nextInt();
        System.out.println("Kamatláb: ");
        int interestRate = scanner.nextInt();

        Investment investment = new Investment(fund, interestRate);

        System.out.println("Hozam 50 napra: " + investment.getYield(50));
        System.out.println("Kivett összeg 80 nap után: " + investment.close(80));
        System.out.println("Kivett összeg 90 nap után: " + investment.close(90));
    }
}
