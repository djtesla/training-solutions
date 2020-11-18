package week04;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {


    public static void main(String[] args) {

        Random rnd = new Random();
        int randomNumber = rnd.nextInt(101);
        Scanner scanner = new Scanner(System.in);

        System.out.println("gondoltam 1 és 100 között egy számra, találd ki, hogy, melyik az!");



    int tipNumber = 0;
        do {

            System.out.println("Írd be tipped: ");
            tipNumber = scanner.nextInt();

            if (tipNumber > randomNumber) {
                System.out.println("A szám amire gondoltam, a tippednél kisebb.");

            } else if (tipNumber < randomNumber) {
                System.out.println("A szám amire gondoltam, a tippednél nagyobb.");
            }

            }  while (tipNumber != randomNumber) ;


            System.out.println("Eltaláltad, gratulálok! A szám, amire gondoltam: " + randomNumber);
        }
    }



