package postcoursegyak.eniko;

public class NumberOfDigits {

    public int getNumberOfDigits(int number) {
        int count = 0;
        for (int i = 1; i < number; i++) {
            int l = Integer.valueOf(i).toString().length();
            count+=l;
        }
        return count;
    }

    public int getNumberOfDigitsWithStringBuilder(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <number; i++) {
            sb.append(i);
        }
        System.out.println(sb.toString());
        return sb.toString().length();
    }



  /*  A NumberOfDigits osztályba írj egy getNumberOfDigits() metódust, amely egy egész számot vár paraméterül!
        A metódus adja vissza azt, hogy ha 1-től kezdve a paraméterként átadott számig leírjuk az összes egész
        számot, akkor hány számjegyet írtunk le!
*/

    public static void main(String[] args) {
        System.out.println(new NumberOfDigits().getNumberOfDigits(152));
        System.out.println(new NumberOfDigits().getNumberOfDigitsWithStringBuilder(152));
    }

}