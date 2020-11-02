package localvariables;

public class DistanceMain {
    public static void main(String[] args) {
        Distance distance = new Distance();
        System.out.println(distance.getValue() + ", " + distance.isAccuracy());
        int intValue = (int) distance.getValue();
        System.out.println(intValue);

    }
}
