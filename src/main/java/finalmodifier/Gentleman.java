package finalmodifier;

public class Gentleman {

    public static final String MESSAGE_PREFIX ="Hello";

    public static final Gentleman gentleman = new Gentleman();

    public String sayHello(String name) {
        return MESSAGE_PREFIX + " " +  name + "!";
    }

    public static void main(String[] args) {

        System.out.println(gentleman.sayHello("Ernő"));

        Gentleman gentleman2 = new Gentleman();

        System.out.println(gentleman2.sayHello("Ernő"));

    }
}
