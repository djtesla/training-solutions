package vizsgafelkészülés03;

public class Switch2
{
    final static short x = 2;
    public static int y = 0;
    public static void main(String [] args) {


        double y = 100.1;


        for (int z=0; z < 4; z++)
        {
            switch (z)
            {
                case x: System.out.print("0 ");
                case x-1: System.out.print("1 ");
                    break;
                case x-25: System.out.print("2 ");
                default: System.out.print("def ");
                return;
            }
        }
    }
}