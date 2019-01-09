package models.participants;

import contracts.Targetable;

public abstract class BaseTarget implements Targetable {
	
	private String name;
	
	private double health;
	
	private double gold;
	
	private boolean isAlive;
	
	
	protected BaseTarget(String name) {
		this.name = name;
		this.isAlive = true;
	}
	
	
	@Override
	public String attack(Targetable target) {
		StringBuilder result = new StringBuilder();
		
		if (!this.isAlive()) {
			return this.getName() + " is dead! Cannot attack.";
		}
		
		if (!target.isAlive()){
			return target.getName() + " is dead! Cannot be attacked.";
		}
		
		target.takeDamage(this.getDamage());
		
		result.append(this.getName()).append(" attacked!");
		if (!target.isAlive()) {
			this.levelUp();
			target.giveReward(this);
			result.append(String.format(" %s has been slain by %s.", target.getName(), this.getName()));
		}
		
		return result.toString();
	}
	
	@Override
	public void takeDamage(double damage) {
		this.setHealth(this.getHealth()-damage);
		if (this.getHealth()<=0){
			this.isAlive = false;
		}
	}
	
	@Override
	public void giveReward(Targetable targetable) {
		targetable.receiveReward(this.getGold());
		this.setGold(0);
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public double getHealth() {
		return this.health;
	}
	
	@Override
	public void setHealth(double health) {
		this.health = health;
	}
	
	@Override
	public double getGold() {
		return this.gold;
	}
	
	protected void setGold(double gold) {
		this.gold = gold;
	}
	
	@Override
	public boolean isAlive() {
		return this.isAlive;
	}

	
}
