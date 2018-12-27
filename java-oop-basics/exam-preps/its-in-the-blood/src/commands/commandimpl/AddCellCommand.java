package commands.commandimpl;

import commands.BaseCommand;
import entities.Cluster;
import entities.Organism;
import entities.Position;
import entities.cells.Cell;
import factories.CellFactory;
import factories.CellFactoryImpl;
import repositories.Repository;

public class AddCellCommand extends BaseCommand {
	public AddCellCommand(Repository organismRepository) {
		super(organismRepository);
	}
	
	
	@Override
	public String execute(String[] args) {
		if (args.length != 9) {
			return "Invalid input.";
		}
		CellFactory cellFactory = new CellFactoryImpl();
		
		Organism organism = (Organism) super.getOrganismRepository().findEntityByName(args[1]);
		if (organism == null) {
			return "No organism with name " + args[1] + " found.";
		}
		Cluster cluster = organism.findClusterById(args[2]);
		if (cluster == null) {
			return "No cluster with name " + args[2] + " found.";
		}
		Position position = null;
		try {
			position = new Position(Integer.parseInt(args[6]), Integer.parseInt(args[7]));
		} catch (NumberFormatException e) {
			return "Invalid input.";
		}
		Cell cell;
		try {
			cell = cellFactory.createCell(args[3], args[4], Integer.parseInt(args[5]), position, Integer.parseInt(args[8]));
		} catch (NumberFormatException e) {
			return "Invalid input.";
		}
		
		if (cluster.validatePosition(cell.getPosition())){
			cluster.addCell(cell);
		}else {
			return "Position not valid.";
		}
		
		return String.format("Organism %s: Created cell %s in cluster %s",
				organism.getName(), cell.getId(), cluster.getId());
	}
}
