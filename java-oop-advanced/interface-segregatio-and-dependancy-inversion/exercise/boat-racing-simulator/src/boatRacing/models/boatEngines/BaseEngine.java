package boatRacing.models.boatEngines;

import boatRacing.Utility.Constants;
import boatRacing.Utility.Validator;

public abstract class BaseEngine implements Engine {
	
	private String model;
	
	private int cachedOutput;
	
	private int horsepower;
	
	private int displacement;
	
	protected BaseEngine(String model, int horsePower, int displacement) {
		this.setModel(model);
		this.setHorsepower(horsePower);
		this.setDisplacement(displacement);
	}
	
	@Override
	public String getModel() {
		return model;
	}
	private void setModel(String model) throws IllegalArgumentException {
		Validator.ValidateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
		this.model = model;
	}
	
	protected int getHorsepower() {
		return horsepower;
	}
	private void setHorsepower(int horsepower) throws IllegalArgumentException {
		Validator.ValidatePropertyValue(horsepower, "Horsepower");
		this.horsepower = horsepower;
	}
	
	protected int getDisplacement() {
		return displacement;
	}
	private void setDisplacement(int displacement) throws IllegalArgumentException {
		Validator.ValidatePropertyValue(displacement, "Displacement");
		this.displacement = displacement;
	}
}
