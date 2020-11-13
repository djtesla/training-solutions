package introexceptions;

public class SsnValidator {

    public boolean isValidSsn (String ssn) {

        if (ssn.length() != 9) {
            return false;
        }

        int sum = 0;

        for (int i = 0; i < ssn.length() - 1; i++) {
            if (i % 2 == 0) {
                sum += ssn.charAt(i) * 3;
            } else {
                sum += ssn.charAt(i) * 7;
            }
        }

        if (Integer.parseInt(ssn.substring(8,9)) == sum % 10) {
            return true;
            } else {
            return false;
        }

    }



}


