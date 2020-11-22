package recursion;

public class Recursion {


    // 5*4*3*2*1



    public long getFactorial(int n) {

        if (n > 1) {
           long  solution = getFactorial(n - 1);
            return n * solution;
        } else {
            return 1;
        }
    }


    public static void main(String[] args) {


        Recursion recursion = new Recursion();
        System.out.println(recursion.getFactorial(4));

    }

}








