package factories;

import entities.Position;
import entities.cells.Cell;

public interface CellFactory {
	
	Cell createCell(String cellType, String
			cellId, int health, Position position, int additionalProperty);
	
}
