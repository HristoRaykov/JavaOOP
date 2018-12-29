package models;

import interfaces.Attack;
import interfaces.Behavior;
import observers.Observer;
import utils.ReportEventNotifier;

public class Blob implements Observer {
	
	private String name;
	private int currentHealth;
	private int damage;
	private Behavior behavior;
	private Attack attack;
	
	private int initialHealth;
	
	private boolean hasReportEvent;
	
	
	public Blob(String name, int health, int damage, Behavior behavior, Attack attack,boolean flag) {
		this.name = name;
		this.currentHealth = health;
		this.damage = damage;
		this.behavior = behavior;
		this.attack = attack;
		
		this.initialHealth = health;
		
		this.hasReportEvent = flag;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCurrentHealth() {
		return this.currentHealth;
	}
	
	public void setCurrentHealth(int health) {
		this.currentHealth = health;
		
		if (this.currentHealth < 0) {
			if (this.hasReportEvent){
				ReportEventNotifier.reportEvent(String.format("Blob %s was killed ",this.getName()));
			}
			this.currentHealth = 0;
		}
		
		if (this.currentHealth <= this.initialHealth / 2 && !this.behavior.isTriggered()) {
			this.getBehavior().trigger(this);
			if (this.hasReportEvent){
				ReportEventNotifier.reportEvent(String.format("Blob %s toggled %sBehavior",
						this.getName(),this.getBehavior().getClass().getSimpleName()));
			}
		}
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	private Behavior getBehavior() {
		return this.behavior;
	}
	
	private Attack getAttack() {
		return attack;
	}
	
	public void attack(Blob target) {
		if (this.getCurrentHealth() == 0 || target.getCurrentHealth() == 0) {
			return;
		}
		this.getAttack().execute(this, target);
	}
	
	@Override
	public void update() {
		if (this.behavior.isTriggered()) {
			this.getBehavior().applyRecurrentEffect(this);
		}
	}
	
	
	@Override
	public String toString() {
		if (this.getCurrentHealth() <= 0) {
			return String.format("Blob %s KILLED", this.getName());
		}
		
		return String.format("Blob %s: %s HP, %s Damage", this.getName(), this.getCurrentHealth(), this.getDamage());
	}
	
	
}
