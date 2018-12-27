package entities.cells;

import entities.Position;

public class Virus extends Microbe {
	
	public Virus(String id, int health, Position position, int virulence) {
		super(id, health, position, virulence);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString()).append(this.getEnergy()).append(System.lineSeparator());
		
		return sb.toString();
	}
}
