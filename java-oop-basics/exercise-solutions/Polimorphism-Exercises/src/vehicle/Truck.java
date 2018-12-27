package vehicle;

public class Truck extends Vehicle {

    public Truck(double fuel, double consumption) {
        super(fuel, consumption + 1.6);
    }

    @Override
    public void drive(double distance) {
        if(super.getFuel() < distance * super.getConsumption()){
            throw new IllegalArgumentException("Truck needs refueling");
        }
        super.setFuel(super.getFuel() - distance * super.getConsumption());
    }

    @Override
    public void refuel(double fuel) {
        super.setFuel(super.getFuel() + (fuel * 0.95));
    }
}
