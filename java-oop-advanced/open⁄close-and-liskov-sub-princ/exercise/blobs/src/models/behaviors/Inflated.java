package models.behaviors;

import models.Blob;

public class Inflated extends AbstractBehavior {
	
	private static final int INFLATED_HEALTH_INCREASE = 50;
	private static final int INFLATED_HEALTH_DECREMENT = 10;
	
	@Override
	public void trigger(Blob source) {
		source.setCurrentHealth(source.getCurrentHealth()+INFLATED_HEALTH_INCREASE);
		super.setIsTriggered(true);
	}
	
	@Override
	public void applyRecurrentEffect(Blob source) {
		int health = source.getCurrentHealth()-INFLATED_HEALTH_DECREMENT;
		if (super.toDelayRecurrentEffect()){
			super.setToDelayRecurrentEffect(false);
		}else {
			source.setCurrentHealth(health);
		}
	}
}
