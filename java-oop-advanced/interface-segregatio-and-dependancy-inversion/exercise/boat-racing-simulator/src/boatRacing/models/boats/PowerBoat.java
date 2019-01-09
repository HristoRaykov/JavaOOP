package boatRacing.models.boats;

import boatRacing.models.Race;
import boatRacing.models.boatEngines.Engine;

public class PowerBoat extends MotorBoat {
	
	private Engine firstEngine;
	
	private Engine secondEngine;
	
	public PowerBoat(String model, int weight, Engine firstEngine, Engine secondEngine) {
		super(model, weight);
		this.setFirstEngine(firstEngine);
		this.setSecondEngine(secondEngine);
	}
	
	public Engine getFirstEngine() {
		return firstEngine;
	}
	
	private void setFirstEngine(Engine firstEngine) {
		this.firstEngine = firstEngine;
	}
	
	public Engine getSecondEngine() {
		return secondEngine;
	}
	
	private void setSecondEngine(Engine secondEngine) {
		this.secondEngine = secondEngine;
	}
	
	@Override
	public double calculateRaceSpeed(Race race) {
		return this.getFirstEngine().calculateOutput()+this.getSecondEngine().calculateOutput() -
		    super.getWeight() + (race.getOceanCurrentSpeed() / 5d);
	}
}
