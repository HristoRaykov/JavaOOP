package commands.commandimpl;

import commands.BaseCommand;
import entities.Cluster;
import entities.Organism;
import repositories.Repository;

public class ActivateClusterCommand extends BaseCommand {
	public ActivateClusterCommand(Repository organismRepository) {
		super(organismRepository);
	}
	
	@Override
	public String execute(String[] args) {
		
		Organism organism = (Organism) super.getOrganismRepository().findEntityByName(args[1]);
		if (organism == null) {
			return "No organism with name " + args[1] + " found.";
		}
		
		Cluster cluster = organism.getClusterInOrder();
		if (cluster == null) {
			return "No clusters found.";
		}
		
		cluster.activate();
		
		return String.format("Organism %s: Activated cluster %s.Cells left: %d",
				organism.getName(),cluster.getId(),cluster.getCells().size());
	}
}
