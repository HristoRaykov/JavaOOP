package boatRacing;

import boatRacing.Core.CommandHandler;
import boatRacing.Core.CommandHandlerImpl;
import boatRacing.Core.AppEngine;
import boatRacing.controllers.BoatSimulatorController;
import boatRacing.controllers.BoatSimulatorControllerImpl;
import boatRacing.database.BoatEngineRepository;
import boatRacing.database.BoatRepository;
import boatRacing.database.BoatSimulatorDatabase;
import boatRacing.database.Repository;
import boatRacing.models.boatEngines.Engine;
import boatRacing.models.boats.Boat;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
	
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    
	    Repository<Boat> boatRepository = new BoatRepository();
	    Repository<Engine> boatEngineRepository = new BoatEngineRepository();
	    BoatSimulatorDatabase database = new BoatSimulatorDatabase(boatRepository,boatEngineRepository);
	
	    BoatSimulatorController controller = new BoatSimulatorControllerImpl(database);
	    
	    CommandHandler commandHandler = new CommandHandlerImpl(controller);
	
	    AppEngine appEngine = new AppEngine(commandHandler,reader);
        appEngine.run();
    }
}
