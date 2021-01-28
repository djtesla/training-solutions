package week04d01;

public class Fibonacci {


    // 1+1+2+3+5+8+13+21+34

    public int getFibonacci (int n) {

        if (n <1) {

            return 1;
        } else {
            return getFibonacci(n-1) + getFibonacci(n-2);

        }


    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        System.out.println(fibonacci.getFibonacci(7));
    }
}
