package commands.commandimpl;

import commands.BaseCommand;
import entities.Organism;
import repositories.Repository;

public class CreateOrganismCommand extends BaseCommand {
	
	
	public CreateOrganismCommand(Repository organismRepository) {
		super(organismRepository);
	}
	
	@Override
	public String execute(String[] args) {
		
		Organism organism = new Organism(args[1]);
		String result = null;
		try {
			result = super.getOrganismRepository().save(organism);
		} catch (Exception e) {
			result = "Invalid input.";
		}
		
		return result;
	}
}
