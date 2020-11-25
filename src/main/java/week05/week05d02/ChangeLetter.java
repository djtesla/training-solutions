package week05.week05d02;

import java.util.Arrays;
import java.util.List;

public class ChangeLetter {

    public static String changeVowels(String text) {

        List<Character> englishVowels = Arrays.asList('a', 'e','i', 'o', 'u');

        for(int i = 0; i < text.length(); i++) {
            if (englishVowels.contains(text.toLowerCase().charAt(i))) {
                text = text.replace(text.charAt(i), '*');
            }
        }
        return text;
    }



    public static void main(String[] args) {

        System.out.println(changeVowels("dghzhnfgeeerr3we"));

    }



    // A week05d02.ChangeLetter osztályban írj meg egy String changeVowels(String) metódust, mely kicseréli a paraméterként átadott szövegben
    // az angol magánhangzókat csillag karakterre. Írj hozzá teszteseteket is!

}
