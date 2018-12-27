package factories;

import entities.Position;
import entities.cells.*;

public class CellFactoryImpl implements CellFactory {
	
	@Override
	public Cell createCell(String cellType, String cellId, int health, Position position, int additionalProperty) {
		Cell cell = null;
		switch (cellType) {
			case "RedBloodCell":
				cell = new RedBloodCell(cellId, health, position, additionalProperty);
			break;
			case "WhiteBloodCell":
				cell = new WhiteBloodCell(cellId, health, position, additionalProperty);
			break;
			case "Bacteria":
				cell =  new Bacteria(cellId, health, position, additionalProperty);
			break;
			case "Fungi":
				cell = new Fungi(cellId, health, position, additionalProperty);
			break;
			case "Virus":
				cell =  new Virus(cellId, health, position, additionalProperty);
			break;
			
		}
		
		return cell;
	}
}
