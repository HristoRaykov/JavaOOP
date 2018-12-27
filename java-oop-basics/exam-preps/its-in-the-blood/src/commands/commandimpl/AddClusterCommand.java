package commands.commandimpl;

import commands.BaseCommand;
import entities.Cluster;
import entities.Organism;
import factories.ClusterFactory;
import factories.ClusterFactoryImpl;
import repositories.Repository;

public class AddClusterCommand extends BaseCommand {
	
	public AddClusterCommand(Repository organismRepository) {
		super(organismRepository);
	}
	
	@Override
	public String execute(String[] args) {
		
		if (args.length!=5){
			return "Invalid input.";
		}
		ClusterFactory clusterFactory = new ClusterFactoryImpl();
		
		Organism organism = (Organism) super.getOrganismRepository().findEntityByName(args[1]);
		if (organism==null){
			return "No organism with name "+args[1]+" found.";
		}
		Cluster cluster;
		
		try {
			cluster= clusterFactory.createCluster(args[2],Integer.parseInt(args[3]),Integer.parseInt(args[4]));
		} catch (NumberFormatException e) {
			return "Invalid input.";
		}
		
		if (organism.containsCluster(cluster.getId())){
			return String.format("Organism %s already have a cluster with id %s",organism.getName(),cluster.getId());
		}
		
		organism.addCluster(cluster);
		
		return String.format("Organism %s: Created cluster %s",organism.getName(),cluster.getId());
	}
}
