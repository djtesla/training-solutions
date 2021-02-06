package clone.timesheet;

public class Project {
    private String name;

    public Project(String name) {
        this.name = name;
    }

    public Project(Project another) {
        this.name = another.name;
    }


    public String getName() {
        return name;
    }

}

