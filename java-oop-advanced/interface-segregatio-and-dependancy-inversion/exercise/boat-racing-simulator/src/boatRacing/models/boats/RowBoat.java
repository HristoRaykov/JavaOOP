package boatRacing.models.boats;

import boatRacing.Utility.Validator;
import boatRacing.models.Race;

public class RowBoat extends BaseBoat {

	private int oars;
	
	public RowBoat(String model, int weight, int oars) {
		super(model, weight);
		this.setOars(oars);
	}
	
	public int getOars() {
		return oars;
	}
	
	private void setOars(int oars) throws IllegalArgumentException{
		Validator.ValidatePropertyValue(oars, "Oars");
		this.oars = oars;
	}
	
	@Override
	public double calculateRaceSpeed(Race race) {
		return this.getOars() * 100.0 - super.getWeight() + race.getOceanCurrentSpeed();
	}
	
}
