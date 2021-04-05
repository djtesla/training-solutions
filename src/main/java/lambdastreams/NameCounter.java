package lambdastreams;

public class NameCounter {

    private int onePartName;
    private int twoPartName;

    public NameCounter() {
    }

    public NameCounter(int onePartName, int twoPartName) {
        this.onePartName = onePartName;
        this.twoPartName = twoPartName;
    }

    public int getOnePartName() {
        return onePartName;
    }

    public int getTwoPartName() {
        return twoPartName;
    }

    public NameCounter add(Employee employee) {
        if (employee.getName().split(" ").length == 1) {
            return new NameCounter(onePartName + 1, twoPartName);
        } else {
            return new NameCounter(onePartName, twoPartName + 1);
        }
    }


    public NameCounter add(NameCounter other) {
    return new NameCounter(onePartName + other.getOnePartName(), twoPartName + other.getTwoPartName());
    }

}
