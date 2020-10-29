package classstructureattributes;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Song song = new Song();

        System.out.println("Dal szerzője: ");
        song.band = scanner.nextLine();
        System.out.println("Dal címe: ");
        song.title = scanner.nextLine();
        System.out.println("Dal hossza(perc):");
        song.length = scanner.nextInt();
        System.out.println(song.band + " - " + song.title + " " + song.length);
    }

}
