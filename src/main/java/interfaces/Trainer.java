package interfaces;

public class Trainer implements HasName {

    private String name;


    public int getYearOfBirth () {
        return 1980;

    }
    @Override
    public String getName() {
        return name;
    }
}

