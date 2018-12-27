package commands;

import repositories.Repository;

public abstract class BaseCommand implements Command {
	
	private Repository organismRepository;
	
	public BaseCommand(Repository organismRepository) {
		this.organismRepository = organismRepository;
	}
	
	protected Repository getOrganismRepository() {
		return organismRepository;
	}
	
	
}
