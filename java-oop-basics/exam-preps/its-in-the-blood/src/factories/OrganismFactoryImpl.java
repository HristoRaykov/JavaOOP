package factories;

import entities.Organism;

public class OrganismFactoryImpl implements OrganismFactory {
	@Override
	public Organism createOrganism(String name) {
		return new Organism(name);
	}
}
