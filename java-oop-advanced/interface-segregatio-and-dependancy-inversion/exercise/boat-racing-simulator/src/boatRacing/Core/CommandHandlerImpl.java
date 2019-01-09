package boatRacing.Core;

import boatRacing.Utility.Constants;
import boatRacing.controllers.BoatSimulatorController;
import boatRacing.exeptions.*;


import java.util.List;

public class CommandHandlerImpl implements CommandHandler {
	
	private BoatSimulatorController controller;
	
	public CommandHandlerImpl(BoatSimulatorController controller) {
		this.setController(controller);
	}
	
	private BoatSimulatorController getController() {
		return controller;
	}
	
	private void setController(BoatSimulatorController controller) {
		this.controller = controller;
	}
	
	@Override
	public String ExecuteCommand(String name, List<String> params) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
		switch (name) {
			case "CreateBoatEngine":
				return this.getController().createBoatEngine(
						params.get(0),
						Integer.parseInt(params.get(1)),
						Integer.parseInt(params.get(2)),
						params.get(3));
			case "CreateRowBoat":
				return this.getController().createRowBoat(
						params.get(0),
						Integer.parseInt(params.get(1)),
						Integer.parseInt(params.get(2)));
			case "CreateSailBoat":
				return this.getController().createSailBoat(
						params.get(0),
						Integer.parseInt(params.get(1)),
						Integer.parseInt(params.get(2)));
			case "CreatePowerBoat":
				return this.getController().createPowerBoat(
						params.get(0),
						Integer.parseInt(params.get(1)),
						params.get(2),
						params.get(3));
			case "CreateYacht":
				return this.getController().createYacht(
						params.get(0),
						Integer.parseInt(params.get(1)),
						params.get(2),
						Integer.parseInt(params.get(3)));
			case "OpenRace":
				return this.getController().openRace(
						Integer.parseInt(params.get(0)),
						Integer.parseInt(params.get(1)),
						Integer.parseInt(params.get(2)),
						Boolean.parseBoolean(params.get(3)));
			case "SignUpBoat":
				return this.getController().signUpBoat(params.get(0));
			case "StartRace":
				return this.getController().startRace();
			case "GetStatistic":
				return this.getController().getStatistic();
			default:
				throw new IllegalArgumentException();
		}
	}
}
