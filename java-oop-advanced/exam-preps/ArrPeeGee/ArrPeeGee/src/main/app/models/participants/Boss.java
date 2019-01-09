package models.participants;

import models.Config;

public class Boss extends BaseTarget {
	
	
	protected Boss(String name) {
		super(name);
		super.setHealth(Config.BOSS_HEALTH);
		super.setGold(Config.BOSS_GOLD);
		
	}
	
	@Override
	public double getDamage() {
		return Config.BOSS_DAMAGE;
	}
	
	@Override
	public void receiveReward(double reward) {
		super.setGold(super.getGold()+reward*0.1);
	}
	
	@Override
	public void levelUp() {
		super.setHealth(Config.BOSS_HEALTH);
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		result
				.append(" Name: ").append(super.getName()).append(" | Class: Boss")
				.append(System.lineSeparator())
				.append(String.format("Health: %.2f | Damage: %.2f | %.2f Gold",
						super.getHealth(),this.getDamage(),super.getGold()));
		
		return result.toString();
	}
}
