package week04;

import java.util.Scanner;

public class NameChanger {

    private String fullName; //Vezetéknév Keresztnév


    public String getFullName() {
        return fullName;
    }

    public NameChanger(String fullName) {

        if (fullName == null || fullName.equals("")) {
        throw new IllegalArgumentException("Invalid name:" + fullName);
        }

        this.fullName = fullName;
    }

    public void changeFirstName (String firstName) {

        //define first- and last names

        Scanner scanner = new Scanner(fullName);

        String lastName = scanner.next();
        String firstNameToBeChanged = scanner.next();

        String newFullName = lastName + " " + firstName;

        fullName = newFullName;

}

    public boolean isTheSameTest() {

        return true;
    }

    public static void main(String[] args) {
        NameChanger nameChanger = new NameChanger("Kiss János");

        nameChanger.changeFirstName("Géza");

        System.out.println(nameChanger.fullName);
    }


}
