package factories;

import entities.Organism;

public interface OrganismFactory {
	
	Organism createOrganism(String name);
}
