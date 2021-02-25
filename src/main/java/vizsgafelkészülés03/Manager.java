package vizsgafelkészülés03;

public class Manager extends Employee{

    private String team;

    public Manager(String team) {
        this.team = team;
    }

    private Manager() {
    }

    public Manager(String name, int salary, Location location, String team) {
        super(name, salary, location);
        this.team = team;


    }


    @Override
    public void meti() {



    }

    public static void proba() {
        System.out.println("x");

    }


}
