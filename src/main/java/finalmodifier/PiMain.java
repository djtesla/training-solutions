package finalmodifier;

public class PiMain {
    public static void main(String[] args) {

        CylinderCalculator cylinderCalculator = new CylinderCalculator();

        System.out.println(cylinderCalculator.calculateSurfaceArea(10, 10));

        System.out.println((cylinderCalculator.calculateVolume(10, 10)));

    }
}
