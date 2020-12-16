package virtualmethod.vehicle;

public class Car extends Vehicle{

    private int numberOfPassenger;

    public Car(int vehicleWeight, int numberPassenger) {
        super(vehicleWeight);
        this.numberOfPassenger = numberPassenger;
    }

    public int getNumberPassenger() {
        return numberOfPassenger;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + numberOfPassenger * Vehicle.PERSON_AVERAGE_WEIGHT;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfPassenger=" + numberOfPassenger + ", vehicleWeight=" + getVehicleWeight() + '}';
    }
}
