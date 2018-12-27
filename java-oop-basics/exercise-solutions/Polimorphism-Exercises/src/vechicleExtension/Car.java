package vechicleExtension;

public class Car extends Vehicle {

    public Car(double fuel, double consumption, double capacity) {
        super(fuel, consumption + 0.9, capacity);
    }


    @Override
    public void drive(double distance) {
        if(super.getFuel() < distance * super.getConsumption()){
            throw new IllegalArgumentException("Car needs refueling");
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
        super.setFuel(super.getFuel() + fuel);
    }
}
