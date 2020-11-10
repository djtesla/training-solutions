package references.parameters;

public class ReferencesMain {


    public static void main(String[] args) {

        Person person1;
        Person person2;

        person1 = new Person("Dadogós Dani", 9);
        person2 = person1;

        person2.setName("Ronáldó");

        System.out.println(person1);
        System.out.println(person2);


        int x;
        int y;

        x = 24;
        y = x;
        y += 1;

        System.out.println(x + ", " + y);
    }

}
