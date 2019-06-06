package vechicleExtension;

public abstract class Vehicle {
    private double fuel;
    private double consumption;
    private double capacity;

    public Vehicle(double fuel, double consumption, double capacity) {
        this.fuel = fuel;
        this.consumption = consumption;
        this.capacity = capacity;
    }

    protected void setFuel(double fuel) {
        this.fuel = fuel;
    }

    protected final double getFuel() {
        return fuel;
    }

    protected final double getConsumption() {
        return consumption;
    }

    protected final double getCapacity() {
        return capacity;
    }

    protected final void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public abstract void drive(double distance);
    public abstract void refuel(double fuel);
}
