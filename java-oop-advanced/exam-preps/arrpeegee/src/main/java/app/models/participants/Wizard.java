package app.models.participants;

import app.models.Config;

public class Wizard extends BaseHero {
	
	private static final int INTELLIGENCE_MULTIPLIER = 5;
	
	protected Wizard(String name) {
		super(name);
		super.setStrength(Config.WIZARD_BASE_STRENGTH);
		super.setDexterity(Config.WIZARD_BASE_DEXTERITY);
		super.setIntelligence(Config.WIZARD_BASE_INTELLIGENCE);
		super.setHealth(super.getStrength()*Config.HERO_HEALTH_MULTIPLIER);
	}
	
	@Override
	public double getDamage() {
		return super.getIntelligence()*INTELLIGENCE_MULTIPLIER + super.getDexterity();
	}
}
