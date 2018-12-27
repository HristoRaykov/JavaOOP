package vechicleExtension;

public class Truck extends Vehicle {

    public Truck(double fuel, double consumption, double capacity) {
        super(fuel, consumption + 1.6, capacity);
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
        if(super.getFuel() + fuel > super.getCapacity()){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }else if(fuel <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        super.setFuel(super.getFuel() + (fuel * 0.95));
    }
}
