package finalmodifier;

public class Circle {
    private final double r;

    public static  final  double PI = 3.14;

    public Circle(double r) {
        this.r = r;
    }

    public double calculatePerimeter(double r) {
        return 2 * r * PI;
    }


}
