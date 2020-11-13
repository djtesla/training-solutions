package introexceptions;

public class Patient {

    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;


    public Patient(String name, String ssn, int yearOfBirth) {

        if (name.equals("") || name == null) {
            throw new IllegalArgumentException("name cannot be null or empty.");
            } else {
            this.name = name;
        }

        if (!new SsnValidator().isValidSsn(ssn)) {
            throw new IllegalArgumentException("social security number is not invalid.");
        } else {
            this.socialSecurityNumber = ssn;
        }

        if (yearOfBirth <= 1900) {
            throw new IllegalArgumentException("year of birth cannot be before 1900.");
        } else {
            this.name = name;
        }
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public static void main(String[] args) {

        Patient patient = new Patient("Jocika", "111111111", 1990);

        Patient patient2 = new Patient("Gézu bácsi", "222222222", 1899);
    }
}
