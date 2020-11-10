package literals;

public class LiteralsMain {
    public static void main(String[] args) {


        String sumOfNumbers = "1" + "2";
        // System.out.println(sumOfNumbers);

        System.out.println(0b1111_1111);

        System.out.println(-12e4);


        long l = 100_000_000_000L; //alapéterelmezettint tartománynak túl nagy a szám

        float f = 1.0F; // doubldeként értelmezett tartomány nem fér bele a float tartomnyba

        System.out.println("Hello" + '\\' + "World");

        double quotient = 325.0 / 4.0;

        System.out.println(quotient);

        long big = 3_244_444_444L;

        String vicces = "árvíztűrőtükörfúrógép";

        String word = "title".toUpperCase();
        System.out.println(word);

        System.out.println(Integer.toBinaryString(16));
        System.out.println(0b10000);
    }
}