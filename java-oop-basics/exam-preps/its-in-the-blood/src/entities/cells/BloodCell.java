package entities.cells;

import entities.Position;

public abstract class BloodCell extends Cell {
	
	private String type;
	
	BloodCell(String id, int health, Position position) {
		super(id, health, position);
		this.type = "BloodCell";
	}
	
	public String getType() {
		return type;
	}
	
	public void assimilates(Cell cell) {
	
	
	
	}
}
