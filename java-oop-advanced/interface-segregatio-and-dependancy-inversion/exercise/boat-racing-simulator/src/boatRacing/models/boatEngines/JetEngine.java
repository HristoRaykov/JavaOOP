package boatRacing.models.boatEngines;

import boatRacing.models.Modelable;

public class JetEngine extends BaseEngine implements Modelable {
	
    private static final int MULTIPLIER = 5;
	
	public JetEngine(String model, int horsePower, int displacement) {
		super(model, horsePower, displacement);
	}
	
	
	@Override
	public int calculateOutput() {
		return super.getHorsepower()*MULTIPLIER + super.getDisplacement();
	}
}
