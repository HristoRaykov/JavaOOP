package commands.commandimpl;

import commands.BaseCommand;
import entities.Organism;
import repositories.Repository;

public class CheckConditionCommand extends BaseCommand {
	
	
	public CheckConditionCommand(Repository organismRepository) {
		super(organismRepository);
	}
	
	@Override
	public String execute(String[] args) {
		String result = null;
		
		Organism organism = (Organism) super.getOrganismRepository().findEntityByName(args[1]);
		
		if (organism==null){
			result="No organism with name "+args[1]+" found.";
		}else {
			result = organism.toString();
		}
		return result;
		
	}
}
