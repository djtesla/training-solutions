package operators;

public class OperatorsMain {

    public static void main(String[] args) {

       Operators operators = new Operators();
        System.out.println(operators.isEven(9));

        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toBinaryString(16 >> 1));
        System.out.println(Integer.toBinaryString(16 >> 2));

        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toBinaryString(16 << 1));
        System.out.println(Integer.toBinaryString(16 << 2));

        System.out.println(0333);

        int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        int j =Long.valueOf(s, 2).intValue();
        System.out.println(j);
    }

}
