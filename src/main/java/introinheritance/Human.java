package introinheritance;

public abstract class Human {

    public static final int DEFAULT_FREE_TIME = 4;
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Human() {

    }

    public abstract void work ();




    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getDefaultFreeTime() {
        return DEFAULT_FREE_TIME;
    }
    public  int getFreeTime() {
        return DEFAULT_FREE_TIME;
    }

    public static void main(String[] args) {

        Human human = new Trainer("2", 10,null);




    }
}