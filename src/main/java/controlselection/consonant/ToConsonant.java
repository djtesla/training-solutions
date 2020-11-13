package controlselection.consonant;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ToConsonant {

    public String getTypeOfCharacter (char letter) {

        String charStr = Character.toString(letter).toUpperCase();


        for (ToConsonantEnum i: ToConsonantEnum.values()) {

            if (charStr.equals(i.name())) {

                if (i.getIndex() == 1) {
                    return "Mássalhangzót (" + Character.toString(letter) + ") adtál meg.";

                } else {

                    for (int j = i.ordinal() + 1; j < ToConsonantEnum.values().length ; j++) {
                        if (ToConsonantEnum.values()[j].getIndex() == 1) {
                            return "Magánhangzót adtál meg. A sorban következő mássalhangzó: " + ToConsonantEnum.values()[j].name();
                        }
                    }



                }
            }
        }
        return "Nem találtam semmit, az én abc-m a betűdet nem tartalmazza.";
    }






    public static void main(String[] args) {

        ToConsonant toConsonant = new ToConsonant();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem a betűt:");

        char letter = scanner.next().charAt(0);

        System.out.println(toConsonant.getTypeOfCharacter(letter));


    }

    }


