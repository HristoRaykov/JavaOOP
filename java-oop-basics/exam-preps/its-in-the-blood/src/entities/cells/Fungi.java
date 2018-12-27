package entities.cells;

import entities.Position;

public class Fungi extends Microbe {
	
	public Fungi(String id, int health, Position position, int virulence) {
		super(id, health, position, virulence);
	}
	
	@Override
	public int getEnergy() {
		return super.getEnergy()/4;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString()).append(this.getEnergy()).append(System.lineSeparator());
		
		return sb.toString();
	}
}
