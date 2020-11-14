package week03;

public class PhoneParser {



    public Phone parsePhone (String number) {

        int pref = 0;
        int num = 0;

        for (int i = 0; i < number.length(); i++) {

            if (number.substring(i, i + 1).equals("-")) {
                pref = Integer.parseInt(number.substring(0, i));
                num = Integer.parseInt(number.substring(i+1, number.length()));

                return new Phone(pref, num);
            }

        }

        return new Phone(0, 0);
    }

    public static void main(String[] args) {

        PhoneParser phoneParser = new PhoneParser();
        Phone phone = phoneParser.parsePhone("20-8105667");

        System.out.println(phone.getPrefix());
        System.out.println(phone.getNumber());








    }
}
