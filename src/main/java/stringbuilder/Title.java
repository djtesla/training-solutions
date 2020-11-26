package stringbuilder;

public enum Title {

    MR("Mr."), MS("Ms."), DR("Dr."), PROF("Prof.");

    private String name;


    Title(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

}
