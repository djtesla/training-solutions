package vaccinationmanager.userinterface;

public class DataValidation {


    public boolean isValidName(String name) {
        if (!name.isBlank()) {
            return true;
        }
        System.out.println("A név nem lehet üres, kérjük próbálkozzon újra!");
        return false;
    }



    public boolean isValidPostalCode(String postalCode) {
        if (!postalCode.isBlank()) {
            return true;
        }
            System.out.println("Az irányítószám nem lehet üres, kérjük próbálkozzon újra!");
            return false;
        }


    public boolean isValidAge(String ageStr) {
        try {
            int age = Integer.parseInt(ageStr);
            if  (age > 10 && age < 150) {
                return true;
            }
            System.out.println("Az életkornak 10 és 150 között kell lennie, kérjük próbálkozzon újra!");

        } catch (NumberFormatException nfe) {
            System.out.println("Az életkornak számnak kell lennie, kérjük próbálkozzon újra!");
        }
        return false;
    }


    public boolean isValidEmail(String email) {
        if (email.length() > 2 &&
                email.indexOf("@") > 0) {
            return true;
        }
        System.out.println("Az email cím formátuma nem megfelelő, kérjük próbálkozzon újra!");
        return false;
    }

    public boolean isValidSecondEmail (String first, String second) {
        if (first.equals(second)) {
            return true;
        }
        System.out.println("A két email cím eltérő, kérjük próbákozzon újra!!");
        return false;
    }


    public boolean isValidSocSecNumber(String socSecNumber) {

        return false;
    }



    public boolean checkIfExit(String text) {
        try {
            if (Integer.parseInt(text) == 7) {
                throw new ExitException("Kilépett. Futás vége");
            }
        } catch (NumberFormatException nfe) {
            // nem hiba! Stringre mehet tovább a futás
        }
        return false;
    }


}
