package finalmodifier;

public class CircleCalculator {

    public static final double PI = 3.14;

    public static final CircleCalculator circlecalculator = new CircleCalculator();


    double calculatePerimeter(double r) {

        double circleCircumference = 2 * r * PI;

        return circleCircumference;

    }

    double calculateArea(double r) {

        double circleArea = Math.pow(r,2) * PI;

        return circleArea;

    }

    public static void main(String[] args) {

        System.out.println(circlecalculator.calculatePerimeter(10));

        System.out.println(circlecalculator.calculateArea(10));

        System.out.println(PI);



    }

}
