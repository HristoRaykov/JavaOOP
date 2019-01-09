package app.models.participants;

import app.contracts.Hero;
import app.models.Config;

public abstract class BaseHero extends BaseTarget implements Hero {
	
	private static final int STARTED_LEVEL = 1;
	
	private int strength;
	private int dexterity;
	private int intelligence;
	private int level;
	
	public BaseHero(String name) {
		super(name);
		super.setGold(Config.HERO_START_GOLD);
		this.level = STARTED_LEVEL;
	}
	
	public BaseHero() {
		super();
	}
	
	@Override
	public int getStrength() {
		return strength;
	}
	
	@Override
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	@Override
	public int getDexterity() {
		return dexterity;
	}
	
	@Override
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	
	@Override
	public int getIntelligence() {
		return intelligence;
	}
	
	@Override
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	
	public int getLevel() {
		return level;
	}
	
	protected void setLevel(int level) {
		this.level = level;
	}
	
	@Override
	public void receiveReward(double reward) {
		super.setGold(super.getGold()+reward);
	}
	
	@Override
	public void levelUp() {
		this.setStrength(this.getStrength() * Config.LEVEL_UP_MULTIPLIER);
		this.setDexterity(this.getDexterity() * Config.LEVEL_UP_MULTIPLIER);
		this.setIntelligence(this.getIntelligence() * Config.LEVEL_UP_MULTIPLIER);
		this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
		this.level++;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
				.append(System.lineSeparator())
				.append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
				.append(System.lineSeparator())
				.append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(), this.getDexterity(), this.getIntelligence(), this.getGold()));
		return sb.toString();
	}
	
}
