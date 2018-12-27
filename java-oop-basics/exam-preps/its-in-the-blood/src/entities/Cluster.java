package entities;

import entities.cells.Cell;

import java.util.ArrayList;
import java.util.List;

public class Cluster {
	
	private String id;
	
	private int rows;
	
	private int cols;
	
	private List<Cell> cells;
	
	private Cell[][] cellMatrix;
	
	
	public Cluster(String id, int rows, int cols) {
		this.id = id;
		this.rows = rows;
		this.cols = cols;
		this.cells = new ArrayList<>();
		cellMatrix  = new Cell[rows][cols];
	}
	
	public String getId() {
		return id;
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getCols() {
		return cols;
	}
	
	public List<Cell> getCells() {
		return cells;
	}
	
	
	public void addCell(Cell cell) {
		int row = cell.getPosition().getRow();
		int col = cell.getPosition().getColumn();
		this.cellMatrix[row][col] = cell;
		this.getCells().add(cell);
	}
	
	public boolean validatePosition(Position position) {
		return isPositionInRange(position) && isPositionEmpty(position);
	}
	
	private boolean isPositionInRange(Position position) {
		if (position.getRow() < 0 || position.getRow() > this.rows - 1) {
			return false;
		}
		if (position.getColumn() < 0 || position.getColumn() > this.cols - 1) {
			return false;
		}
		return true;
	}
	
	private boolean isPositionEmpty(Position position) {
		return this.getCells().stream()
				.noneMatch(cell -> cell.getPosition().getColumn() == position.getColumn() &&
						cell.getPosition().getRow() == position.getRow());
	}
	
	public void activate(){
		Cell activeCell = null;
		if (this.getCells().size()<2){
			return;
		}
		for (int row = 0; row < this.rows; row++) {
			for (int col = 0; col < this.cols; col++) {
				if (cellMatrix[row][col]!=null && activeCell==null){
					activeCell=cellMatrix[row][col];
					cellMatrix[row][col]=null;
					continue;
				}
				if (activeCell!=null && cellMatrix[row][col]!=null) {
					activeCell = this.meetCells(activeCell,cellMatrix[row][col]);
				}
				if (this.getCells().size()==1){
					return;
				}
			}
		}
		
		
	}
	
	private Cell meetCells(Cell activeCell, Cell otherCell) {
		if (activeCell.getType().equals("BloodCell")){
			activeCell.setHealth(activeCell.getHealth()+otherCell.getHealth());
			adjustPropertiesAfterMeet(activeCell, otherCell);
			return activeCell;
		}else {
			while (true){
				otherCell.setHealth(otherCell.getHealth()-activeCell.getEnergy());
				if (otherCell.getHealth()<=0){
					adjustPropertiesAfterMeet(activeCell,otherCell);
					return activeCell;
				}
				activeCell.setHealth(activeCell.getHealth()-otherCell.getEnergy());
				if (activeCell.getHealth()<=0){
					adjustPropertiesAfterMeet(otherCell,activeCell);
					return otherCell;
				}
			}
		
		}
	}
	
	private void adjustPropertiesAfterMeet(Cell survivоr, Cell loser) {
		survivоr.setPosition(loser.getPosition());
		this.getCells().remove(loser);
		int row = survivоr.getPosition().getRow();
		int col = survivоr.getPosition().getColumn();
		cellMatrix[row][col] = survivоr;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb
				.append("----Cluster ")
				.append(this.getId())
				.append(System.lineSeparator());
		this.getCells().forEach(cell -> sb.append(cell.toString()));
		
		return sb.toString();
	}
}
