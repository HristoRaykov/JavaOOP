package app.models.participants;

import app.models.Config;

public class Warrior extends BaseHero {
	
	private static final int STRENGTH_MULTIPLIER = 2;
	
	
	public Warrior(String name) {
		super(name);
		super.setStrength(Config.WARRIOR_BASE_STRENGTH);
		super.setDexterity(Config.WARRIOR_BASE_DEXTERITY);
		super.setIntelligence(Config.WARRIOR_BASE_INTELLIGENCE);
		super.setHealth(super.getStrength()*Config.HERO_HEALTH_MULTIPLIER);
	}
	
	public Warrior() {
		super();
	}
	
	
	@Override
	public double getDamage() {
		return super.getStrength()*STRENGTH_MULTIPLIER + super.getDexterity();
	}
}
