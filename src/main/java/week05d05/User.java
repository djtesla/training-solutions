package week05d05;

public class User {
    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {

        if (!isValidMail(email)) {
            throw new IllegalArgumentException("Invalid mail address!");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName () {
        return getFirstName() + " " + getLastName();
    }


    public boolean isValidMail (String email) {

        if (!email.contains("@") || !email.contains(".") ||
                email.indexOf(".") == email.length() - 1 ||
                email.indexOf(".") == 0 ||
                email.indexOf("@") == email.length() - 1 ||
                email.indexOf("@") == 0 ||
                !(email.indexOf(".") - email.indexOf("@") > 1) )  {
            return false;
        }
            return true;
        }
    }




/*Mai Junior/Mid feladat:
    Készíts egy osztályt week05d05.User néven, melynek van egy firstName (String),
    egy lastName (String) és egy email (String) mezője. Legyen ellenőrzés az User konstruktorában,
    mely hibát jelez, ha nincs @ és . (pont) az e-mail cimben! Készíts egy metódust is getFullName névvel,
    mely visszaadja a firstName és a lastName változókat összefűzve. Legyen közöttük egy whitespace (" ").
    Bónusz feladat: írjunk teszteket*/

