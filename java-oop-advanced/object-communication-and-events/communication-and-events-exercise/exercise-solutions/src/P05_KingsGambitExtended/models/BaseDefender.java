package P05_KingsGambitExtended.models;

import P05_KingsGambitExtended.models.interfaces.Defender;

public abstract class BaseDefender extends BaseUnit implements Defender {
	
	private int health;
	
	private King king;
	
	public BaseDefender(String name, King king) {
		super(name);
		this.king=king;
		this.king.addDefender(this);
	}
	
	protected void setHealth(int health) {
		this.health = health;
	}
	
	@Override
	public void attacked(){
		this.health--;
		if (health<=0){
			this.king.removeDefender(super.getName());
		}
	}
	
}
