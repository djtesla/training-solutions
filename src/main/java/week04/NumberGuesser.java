package week04;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {


    public static void main(String[] args) {

        Random rnd = new Random();
        int randomNumber = rnd.nextInt(101);
        Scanner scanner = new Scanner(System.in);

        System.out.println("gondoltam 1 és 100 között egy számra, találd ki, hogy, melyik az!");



    String tip = "";
    int tipNumber = 0;
    int i =0;
        do {

            System.out.println("Írd be tipped: ");
            tipNumber =  Integer.parseInt(scanner.nextLine().trim());

            if (tipNumber > randomNumber) {
                System.out.println("A szám amire gondoltam, a tippednél kisebb.");
                i++;

            } else if (tipNumber < randomNumber) {
                System.out.println("A szám amire gondoltam, a tippednél nagyobb.");
                i++;
            }

            }  while (tipNumber != randomNumber && !(i > 10) ) ;


        if (i > 10) {

            System.out.println("Nem találtad ki 5 tipből. A szám amire gondoltam" + randomNumber + ".");
        }    else {
            System.out.println("Eltaláltad, gratulálok! A szám, amire gondoltam: " + randomNumber + ".");
        }
        }
    }



