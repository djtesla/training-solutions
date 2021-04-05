package lambdastreams;

public class NameCounterMod {

    private int onePartName;
    private int twoPartName;

    public NameCounterMod() {
    }

    public NameCounterMod(int onePartName, int twoPartName) {
        this.onePartName = onePartName;
        this.twoPartName = twoPartName;
    }

    public int getOnePartName() {
        return onePartName;
    }

    public int getTwoPartName() {
        return twoPartName;
    }

    public void add(Employee employee) {
        if (employee.getName().split(" ").length == 1) {
            onePartName++;
        } else {
            twoPartName++;
        }
    }

    public void add(NameCounterMod other) {
        onePartName += other.onePartName;
        twoPartName += other.twoPartName;
    }

}
