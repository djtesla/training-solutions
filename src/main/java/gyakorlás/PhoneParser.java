package gyakorlás;

public class PhoneParser {



    public Phone parsePhone (String number) {

        int pref = 0;
        int num = 0;

        for (int i = 0; i < number.length(); i++) {

            if (number.substring(i, i + 1).equals("-")) {
                pref = Integer.parseInt(number.substring(0, i));
                num = Integer.parseInt(number.substring(i, number.length() - 1));

                return new Phone(pref, num);
            }
            return new Phone(0, 0);
        }


    }

    public static void main(String[] args) {

        PhoneParser phoneParser = new PhoneParser();
        System.out.println(phoneParser.parsePhone("20-8105667"));



    }
}
