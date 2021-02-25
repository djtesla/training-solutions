package gyakorlás;

public class User {

    private String name;

    public String getName() {
        return name;
    }

    public User(String name) {
        this.name = name;
    }

    public User(User another) {
        this.name = another.name;
    }
}
