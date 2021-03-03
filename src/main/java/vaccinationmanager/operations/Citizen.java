package vaccinationmanager.operations;

public class Citizen {


    private String name;
    private String postalCode;
    private int age;
    private String email;
    private String socSecNumber;

    public Citizen(String name, String postalCode, int age, String email, String socSecNumber) {
        this.name = name;
        this.postalCode = postalCode;
        this.age = age;
        this.email = email;
        this.socSecNumber = socSecNumber;
    }

    public String getName() {
        return name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getSocSecNumber() {
        return socSecNumber;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", postalCode='" + postalCode + '\'' +
                        ", age=" + age +
                        ", email='" + email + '\'' +
                        ", socSecNumber='" + socSecNumber;
    }
}
