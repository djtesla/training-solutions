package week06.week06d01;

import java.util.Scanner;

public class SeparatedSum {


    public double[] sum (String text) {

        double num, positiveSum =0.0, negativeSum = 0.0;

        try (Scanner scanner = new Scanner(text)) {

            while (scanner.useDelimiter(";").hasNext()) {

                String element = scanner.next();
                element = element.replace(',', '.');
                num = Double.parseDouble(element);

                if (num < 0) {
                    negativeSum += num;
                } else {
                    positiveSum += num;
                }
            }

        }
    return new double[]{positiveSum, negativeSum};
    }


    public static void main(String[] args) {
        SeparatedSum ss = new SeparatedSum();
        System.out.println(ss.sum("1,15;-3,0;45,789;-56,21;78,112233")[0]);
    }

}



/*    Senior feladat: Írj egy week06d01.SeparatedSum.sum(String s) metódust, mely kap egy String-et,
        melyben lebegőpontos számok szerepelnek pontosvesszővel elválasztva. A számoknál vessző a tizedeselválasztó.
        Ezt szétszedi, és összeadja külön a pozitív és külön a negatív számokat. Mivel térnél vissza ebből a metódusból?
        Tesztesetet el ne felejtsd! (edited) */
