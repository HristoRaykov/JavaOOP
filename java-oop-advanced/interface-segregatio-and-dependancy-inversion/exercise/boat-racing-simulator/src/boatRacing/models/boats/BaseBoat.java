package boatRacing.models.boats;

import boatRacing.Utility.Constants;
import boatRacing.Utility.Validator;

public abstract class BaseBoat implements Boat {
	
	private String model;
	
	private int weight;
	
	protected BaseBoat(String model, int weight) {
		this.setModel(model);
		this.setWeight(weight);
	}
	
	@Override
	public String getModel() {
		return model;
	}
	
	private void setModel(String model) throws IllegalArgumentException {
		Validator.ValidateModelLength(model, Constants.MIN_BOAT_MODEL_LENGTH);
		this.model = model;
	}
	
	protected int getWeight() {
		return weight;
	}
	
	private void setWeight(int weight) throws IllegalArgumentException {
		Validator.ValidatePropertyValue(weight,"Weight");
		this.weight = weight;
	}
}
