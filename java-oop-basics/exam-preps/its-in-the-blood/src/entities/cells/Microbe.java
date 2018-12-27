package entities.cells;

import entities.Position;

public abstract class Microbe extends Cell {
	
	private int virulence;
	
	private String type;
	
	public Microbe(String id, int health, Position position, int virulence) {
		super(id, health, position);
		this.virulence = virulence;
		this.type="Microbe";
	}
	
	public int getVirulence() {
		return virulence;
	}
	
	public void setVirulence(int virulence) {
		this.virulence = virulence;
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public int getEnergy() {
		return super.getHealth() + this.getVirulence();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb
				.append(super.toString())
				.append("--------Health: ")
				.append(super.getHealth())
				.append(" | Virulence: ")
				.append(this.getVirulence())
				.append(" | Energy: ");
		
		return sb.toString();
	}
}
