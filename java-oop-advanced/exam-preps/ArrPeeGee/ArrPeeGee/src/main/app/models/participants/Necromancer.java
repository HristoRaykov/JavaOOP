package models.participants;

import models.Config;

public class Necromancer extends BaseHero {
	
	private static final int INTELLIGENCE_MULTIPLIER = 2;
	private static final int DEXTERITY_MULTIPLIER = 2;
	private static final int STRENGTH_MULTIPLIER = 2;
	
	protected Necromancer(String name) {
		super(name);
		super.setStrength(Config.NECROMANCER_BASE_STRENGTH);
		super.setDexterity(Config.NECROMANCER_BASE_DEXTERITY);
		super.setIntelligence(Config.NECROMANCER_BASE_INTELLIGENCE);
		super.setHealth(super.getStrength()*Config.HERO_HEALTH_MULTIPLIER);
	}
	
	@Override
	public double getDamage() {
		return super.getIntelligence() * INTELLIGENCE_MULTIPLIER +
				super.getDexterity() * DEXTERITY_MULTIPLIER +
				super.getStrength() * STRENGTH_MULTIPLIER;
	}
}
