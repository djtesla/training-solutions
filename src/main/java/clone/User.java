package clone;

public class User {

    private String name;



    public User(String name) {
        this.name = name;
    }

    public User(User another) {
        this.name = another.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name='" + name;

    }
}


