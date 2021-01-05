package gyakorlás.vizsga2felkészülés;

public class Human implements  HasName{

    private static final int DEFAULT_FREE_TIME = 4;

    private String name;

    @Override
    public String getName() {
        return name;
    }

    public int getFreeTime () {
        return DEFAULT_FREE_TIME;
    }
}
