package entities.cells;

import entities.Position;

public class RedBloodCell extends BloodCell {
	
	private int velocity;
	
	public RedBloodCell(String id, int health, Position position, int velocity) {
		super(id, health, position);
		this.velocity = velocity;
		
	}
	
	public int getVelocity() {
		return velocity;
	}
	
	
	
	@Override
	public int getEnergy() {
		return super.getHealth()+this.getVelocity();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb
				.append(super.toString())
				.append("--------Health: ")
				.append(super.getHealth())
				.append(" | Velocity: ")
				.append(this.getVelocity())
				.append(" | Energy: ")
				.append(this.getEnergy())
				.append(System.lineSeparator());
		
		return sb.toString();
	}
}
