package array;

public class ArrayMain {

    public static void main(String[] args) {

       /* int[] a = new int[3];
        a[0] = 1;
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[4]);

        int[] a = {1, 2, 3};

        for (int i = 0; i < a.length; i++ ) {
            System.out.println(a[i]);
        }

        for (int item: a) {
            System.out.println(item);
        }

        */

    String[] weekdays = {"hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap"};
       // System.out.println(weekdays[1]);
       // System.out.println(weekdays.length);

        int[] hatvanyok = new int[5];

        for (int i = 0; i < hatvanyok.length; i++) {
            hatvanyok[i] = 2^i;
          //  System.out.println(hatvanyok[i]);
        }
        boolean[] bool = new boolean[6];

        for (int i = 0; i < bool.length; i++) {
            bool[i] =  i % 2 != 0;
         //   System.out.println(bool[i]);
        }

        int[] source = {1,2,3,4};

        ArrayHandler arrayHandler = new ArrayHandler();

        // System.out.println(arrayHandler.contains(source, 3));
        System.out.println(arrayHandler.find(source, 6));


    }

}
