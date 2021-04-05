package lambdaprimitives;

public class Boundary {

    private int min;
    private int max;

    public Boundary(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "min=" + min + ", max=" + max;

    }
}
