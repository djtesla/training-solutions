package inheritanceconstructor.cars;

public class Jeep extends Car {

    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public double getExtraCapacity() {
        return extraCapacity;
    }

    public double getExtraFuel() {
        return extraFuel;
    }




    @Override
    public void drive(int km) {

        if (!isEnoughFuel(km)) {

            throw new IllegalArgumentException("Not enough fuel available!");
        }

        double difFuel = extraFuel - getFuelRate() /100D * km;

        if (difFuel <= 0) {
            extraFuel = 0;
            setFuel(getFuel() - Math.abs(difFuel));

        } else {
            extraFuel = difFuel;
        }


    }

    @Override
    public boolean isEnoughFuel(double km) {

        return  getFuel() + extraFuel - km /100D * getFuelRate() >= 0;

    }


    @Override
    public double calculateRefillAmount() {

        return super.calculateRefillAmount() + extraCapacity - extraFuel;

    }
}
