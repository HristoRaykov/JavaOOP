package vehicle;

public class Car extends Vehicle {

    public Car(double fuel, double consumption) {
        super(fuel, consumption + 0.9);
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
        super.setFuel(super.getFuel() + fuel);
    }
}
