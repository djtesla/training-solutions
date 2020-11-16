package stringtype.registration;

public class UserValidator {

    public boolean isValidUsername (String username) {
        return username != null && !"".equals(username);
    }

    public boolean isValidPassword (String password1, String password2) {
        return password1 != null
                && password1.length() > 7
                && password1.equals(password2);

    }

    public boolean isValidEmail (String email) {
        int atIndex = email.indexOf("@");
        String domain =email.substring((atIndex+1));
        int dotIndex = email.indexOf(".");

        return atIndex > -1
                && dotIndex > 0 && dotIndex > atIndex
                && dotIndex !=domain.length() - 1;

    }
}
