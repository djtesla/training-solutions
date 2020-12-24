package gyakorlás;

public class Person {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Person(String name) {
        this.name = name;
    }

    public static void changeName(Person cumi){
        cumi.setName("Peter");
    }


    public static void main(String[] args) {
        Person person = new Person("Géza");

        changeName(person);

        System.out.println(person.getName());

    }
}
