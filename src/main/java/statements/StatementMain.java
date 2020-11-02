package statements;

public class StatementMain {
    public static void main(String[] args) {
        /* int i =5 + 6;
        System.out.println(5 + 6);

        StatementMain s = new StatementMain();

        System.out.println(i = 8);

        System.out.println("".equals(""));
        System.out.println(!(i % 2 == 0) || true);

        i++;
        i = i + 1;
        System.out.println(i % 2 == 0 ? "páros" : "páratlan"); // 3 operandus, feltétel + kifejezés + kifejezés
*/

        int x = 5 + 6;
        int y = 11 - x;
        int z = 8;

        boolean b = x > y ?  true : false;
        System.out.println(b);

        boolean c = b || z > 5;
        System.out.println(c);
        z++;
        System.out.println(z);

    }
}
