package boatRacing.database;

import boatRacing.models.boatEngines.Engine;
import boatRacing.models.boats.Boat;

public class BoatSimulatorDatabase {
	
    private Repository<Boat> boatRepository;
    private Repository<Engine> boatEngineRepository;
	
	public BoatSimulatorDatabase(Repository<Boat> boatRepository, Repository<Engine> boatEngineRepository) {
		this.boatRepository = boatRepository;
		this.boatEngineRepository = boatEngineRepository;
	}
	
	public Repository<Boat> getBoatRepository() {
		return boatRepository;
	}
	
	public Repository<Engine> getBoatEngineRepository() {
		return boatEngineRepository;
	}
}
