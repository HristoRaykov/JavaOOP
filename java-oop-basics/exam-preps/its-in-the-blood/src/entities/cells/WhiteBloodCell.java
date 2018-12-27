package entities.cells;

import entities.Position;

public class WhiteBloodCell extends BloodCell {
	
	private int size;
	
	public WhiteBloodCell(String id, int health, Position position, int size) {
		super(id, health, position);
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	
	
	@Override
	public int getEnergy() {
		return (super.getHealth()+this.getSize())*2;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb
				.append(super.toString())
				.append("--------Health: ")
				.append(super.getHealth())
				.append(" | Size: ")
				.append(this.getSize())
				.append(" | Energy: ")
				.append(this.getEnergy())
				.append(System.lineSeparator());
		
		return sb.toString();
	}
}
