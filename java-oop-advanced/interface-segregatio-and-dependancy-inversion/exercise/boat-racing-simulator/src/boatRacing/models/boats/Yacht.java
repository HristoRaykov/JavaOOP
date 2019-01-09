package boatRacing.models.boats;

import boatRacing.Utility.Validator;
import boatRacing.models.Race;
import boatRacing.models.boatEngines.Engine;

public class Yacht extends MotorBoat {
	
	private Engine engine;
	
	private int cargoWeight;
	
	public Yacht(String model, int weight, Engine engine, int cargoWeight) {
		super(model, weight);
		this.setEngine(engine);
		this.setCargoWeight(cargoWeight);
	}
	
	public Engine getEngine() {
		return engine;
	}
	
	private void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public int getCargoWeight() {
		return cargoWeight;
	}
	
	private void setCargoWeight(int cargoWeight) throws IllegalArgumentException{
		Validator.ValidatePropertyValue(cargoWeight, "Cargo Weight");
		this.cargoWeight = cargoWeight;
	}
	
	@Override
	public double calculateRaceSpeed(Race race) {
		return this.getEngine().calculateOutput() - super.getWeight() -this.getCargoWeight() +
				(race.getOceanCurrentSpeed()/2d);
	}
}
