package arrayofarrays;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class ArrayOfArraysMain {

    public static final Random RND = new Random();


    public int[][] multiplicationTable(int size) {
        int[][]tombs = new int[size][size];

        for (int i = 0; i < tombs.length; i++ ) {
            for (int j = 0; j < tombs[i].length; j++ ) {
                tombs[i][j] = (i + 1) * (j + 1);
            }
            //System.out.println(Arrays.toString(tombs[i]));
        }
        return tombs;
    }

    public void  printArrayOfArrays(int[][] a) {

        for (int i = 0; i < a.length; i++ ) {

            for (int j = 0; j < a[i].length; j++ ) {
                if (a[i][j] < 10) {
                    System.out.print("   " + a[i][j]);
                } else if (a[i][j] < 100) {
                    System.out.print("  " + a[i][j]);
                } else {
                    System.out.print(" " + a[i][j]);
                }

            }
            System.out.println("");
        }

    }

    public int[][] triangularMatrix(int size) {

            int[][] matrix = new int[size][];

            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = new int[i+1];
                for (int j = 0; j < i+1; j++) {
                    matrix[i][j] = i;
                }
            }
        return matrix;
        }



    public int[][] getValues() {

        int[][] yearsAndDays = new int[12][];

        for (int i = 0; i < 12; i++) {

            int days = 0;

            if (i == 3 || i == 5 || i == 8 || i == 10) {
                days = 30;

            } else if (i == 1) {
                days = 28;

            } else {
                days = 31;
            }

            yearsAndDays[i] = new int[days];

            for (int j = 0; j < days; j++) {

                yearsAndDays[i][j] = RND.nextInt(1000);


            }

        }
        return yearsAndDays;
    }


    public static void main(String[] args) {

        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();

        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.multiplicationTable(5));

        int [] [] tomb2 = new int [3] [];
        tomb2[0] = new int[]{1, 2, 3, 4};
        tomb2[1] = new int[]{11, 22, 33, 44, 55, 66};
        tomb2[2] = new int[]{111, 222, 333, 444, 555, 666, 777, 888};

        arrayOfArraysMain.printArrayOfArrays(tomb2);

        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.triangularMatrix(5));

        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.getValues());


    }


}


