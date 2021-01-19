package ioreadstring.names;

public class Human {

    private String lastName;
    private String firstName;

    public Human(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + "," + lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
