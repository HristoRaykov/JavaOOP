package entities.cells;

import entities.Position;

import java.util.Objects;

public abstract class Cell {
	
	private String id;
	
	private int health;
	
	private Position position;
	
	private String type;
	
	public Cell(String id, int health, Position position) {
		this.id = id;
		this.health = health;
		this.position = position;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public abstract int getEnergy();
	
	public abstract String getType();
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Cell cell = (Cell) o;
		
		if (getHealth() != cell.getHealth()) return false;
		if (getId() != null ? !getId().equals(cell.getId()) : cell.getId() != null) return false;
		return getType() != null ? getType().equals(cell.getType()) : cell.getType() == null;
	}
	
	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + getHealth();
		result = 31 * result + (getType() != null ? getType().hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb
				.append("------Cell ")
				.append(this.getId())
				.append(" [")
				.append(this.getPosition().getRow())
				.append(",")
				.append(this.getPosition().getColumn())
				.append("]")
				.append(System.lineSeparator());
		
		return sb.toString();
	}
}
