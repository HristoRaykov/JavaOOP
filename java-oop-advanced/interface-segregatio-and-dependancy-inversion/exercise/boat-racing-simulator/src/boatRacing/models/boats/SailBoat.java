package boatRacing.models.boats;

import boatRacing.Utility.Constants;
import boatRacing.models.Race;

public class SailBoat extends BaseBoat {

	private int sailEfficiency;
	
	public SailBoat(String model, int weight, int sailEfficiency) {
		super(model, weight);
		this.setSailEfficiency(sailEfficiency);
	}
	
	private int getSailEfficiency() {
		return sailEfficiency;
	}
	
	private void setSailEfficiency(int sailEfficiency) throws IllegalArgumentException {
		if (sailEfficiency < 1 || sailEfficiency > 100) {
			throw new IllegalArgumentException(Constants.INCORRECT_SAIL_EFFICIENCY_MESSAGE);
		}
		this.sailEfficiency = sailEfficiency;
	}
	
	@Override
	public double calculateRaceSpeed(Race race) {
		return (race.getWindSpeed() * (this.getSailEfficiency() / 100d)) -
				super.getWeight() + (race.getOceanCurrentSpeed() / 2d);
	}
}
