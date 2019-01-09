package boatRacing.models.boatEngines;

import boatRacing.models.Modelable;

public class SterndriveEngine extends BaseEngine implements Modelable {
	
    private static final int MULTIPLIER = 7;
	
	public SterndriveEngine(String model, int horsePower, int displacement) {
		super(model, horsePower, displacement);
	}
	
	
	@Override
	public int calculateOutput() {
		return super.getHorsepower()*MULTIPLIER + super.getDisplacement();
	}
}
