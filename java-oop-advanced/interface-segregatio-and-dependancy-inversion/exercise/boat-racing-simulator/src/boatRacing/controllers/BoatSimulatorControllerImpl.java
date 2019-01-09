package boatRacing.controllers;

import boatRacing.Utility.Constants;
import boatRacing.database.BoatSimulatorDatabase;
import boatRacing.exeptions.*;
import boatRacing.models.Race;
import boatRacing.models.RaceImpl;
import boatRacing.models.boatEngines.Engine;
import boatRacing.models.boatEngines.JetEngine;
import boatRacing.models.boatEngines.SterndriveEngine;
import boatRacing.models.boats.*;


import java.util.*;
import java.util.stream.Collectors;

public class BoatSimulatorControllerImpl implements BoatSimulatorController {
	
	private Map<Boat, Double> finishedBoats;
	
	private Map<Boat, Double> notFinishedBoats;
	
	private BoatSimulatorDatabase database;
	
	private Race currentRace;
	
	public BoatSimulatorControllerImpl(BoatSimulatorDatabase database) {
		this.setDatabase(database);
		this.finishedBoats = new LinkedHashMap<>();
		this.notFinishedBoats = new LinkedHashMap<>();
	}
	
	
	@Override
	public BoatSimulatorDatabase getDatabase() {
		return this.database;
	}
	
	private void setDatabase(BoatSimulatorDatabase database) {
		this.database = database;
	}
	
	@Override
	public Race getCurrentRace() {
		return this.currentRace;
	}
	
	private void setCurrentRace(Race currentRace) {
		this.currentRace = currentRace;
	}
	
	
	@Override
	public String createBoatEngine(String model, int horsepower, int displacement, String engineType) throws DuplicateModelException, IllegalArgumentException {
		Engine engine;
		switch (engineType) {
			case "Jet":
				engine = new JetEngine(model, horsepower, displacement);
				break;
			case "Sterndrive":
				engine = new SterndriveEngine(model, horsepower, displacement);
				break;
			default:
				throw new IllegalArgumentException(Constants.INCORRECT_ENGINE_TYPE_MESSAGE);
		}
		
		this.database.getBoatEngineRepository().add(engine);
		return String.format(
				"Engine model %s with %s HP and displacement %s cm3 created successfully.",
				model,
				horsepower,
				displacement);
	}
	
	@Override
	public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
		Boat boat = new RowBoat(model, weight, oars);
		this.database.getBoatRepository().add(boat);
		return String.format("Row boat with model %s registered successfully.", model);
	}
	
	@Override
	public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
		Boat boat = new SailBoat(model, weight, sailEfficiency);
		this.database.getBoatRepository().add(boat);
		return String.format("Sail boat with model %s registered successfully.", model);
	}
	
	@Override
	public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException {
		Engine firstEngine = this.database.getBoatEngineRepository().getItem(firstEngineModel);
		Engine secondEngine = this.database.getBoatEngineRepository().getItem(secondEngineModel);
		Boat boat = new PowerBoat(model, weight, firstEngine, secondEngine);
		this.database.getBoatRepository().add(boat);
		return String.format("Power boat with model %s registered successfully.", model);
	}
	
	@Override
	public String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException {
		Engine engine = this.database.getBoatEngineRepository().getItem(engineModel);
		Boat boat = new Yacht(model, weight, engine, cargoWeight);
		this.database.getBoatRepository().add(boat);
		return String.format("Yacht with model %s registered successfully.", model);
	}
	
	@Override
	public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
		Race race = new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
		this.ValidateRaceIsEmpty();
		this.currentRace = race;
		return
				String.format(
						"A new race with distance %s meters, wind speed %s m/s and ocean current speed %s m/s has been set.",
						distance, windSpeed, oceanCurrentSpeed);
	}
	
	@Override
	public String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
		Boat boat = this.database.getBoatRepository().getItem(model);
		this.ValidateRaceIsSet();
		if (!this.getCurrentRace().areMotorBoatsAllowed() && boat instanceof MotorBoat) {
			throw new IllegalArgumentException(Constants.INCORRECT_BOAT_TYPE_MESSAGE);
		}
		this.getCurrentRace().addParticipant(boat);
		return String.format("Boat with model %s has signed up for the current Race.", model);
	}
	
	@Override
	public String startRace() throws InsufficientContestantsException, NoSetRaceException {
		this.ValidateRaceIsSet();
		List<Boat> participants = this.getCurrentRace().getParticipants();
		if (participants.size() < 3) {
			throw new InsufficientContestantsException(Constants.INSUFFICIENT_CONTESTANTS_MESSAGE);
		}
		
		Map<Boat, Double> winners = this.findFastest(participants);
		
		StringBuilder result = new StringBuilder();
		String[] places = {"First", "Second", "Third"};
		int count = 0;
		for (Map.Entry<Boat, Double> boatDoubleEntry : winners.entrySet()) {
			if (count >= 3) {
				break;
			}
			result.append(String.format("%s place: %s Model: %s Time: %s",
					places[count],
					boatDoubleEntry.getKey().getClass().getSimpleName(),
					boatDoubleEntry.getKey().getModel(),
					this.isFinished(boatDoubleEntry.getValue())))
					.append(System.lineSeparator());
			count++;
		}
		
		this.currentRace = null;
		this.finishedBoats.clear();
		this.notFinishedBoats.clear();
		
		return result.toString();
	}
	
	private String isFinished(Double time) {
		if (time <= 0.0) {
			return "Did not finish!";
		}
		return String.format("%.2f sec", time);
	}
	
	@Override
	public String getStatistic() {
		List<Boat> participants = this.getCurrentRace().getParticipants();
		int participantsCount = participants.size();
		int powerBoatCount = 0;
		int rowBoatCount = 0;
		int sailBoatCount = 0;
		int yachtCount = 0;
		for (Boat participant : participants) {
			if (participant instanceof PowerBoat) {
				powerBoatCount++;
			}
			if (participant instanceof RowBoat) {
				rowBoatCount++;
			}
			if (participant instanceof SailBoat) {
				sailBoatCount++;
			}
			if (participant instanceof Yacht) {
				yachtCount++;
			}
		}
		StringBuilder result = new StringBuilder();
		
		result
				.append(String.format("PowerBoat -> %.2f%%", powerBoatCount * 1.0 / participantsCount * 100))
				.append(System.lineSeparator())
				.append(String.format("RowBoat -> %.2f%%", rowBoatCount * 1.0 / participantsCount * 100))
				.append(System.lineSeparator())
				.append(String.format("SailBoat -> %.2f%%", sailBoatCount * 1.0 / participantsCount * 100))
				.append(System.lineSeparator())
				.append(String.format("Yacht -> %.2f%%", yachtCount * 1.0 / participantsCount * 100));
		return result.toString();
		
	}
	
	private Map<Boat, Double> findFastest(List<Boat> participants) {
		
		for (Boat participant : participants) {
			double speed = participant.calculateRaceSpeed(this.getCurrentRace());
			double time = this.getCurrentRace().getDistance() / speed;
			if (time <= 0) {
				this.notFinishedBoats.putIfAbsent(participant, time);
			} else {
				this.finishedBoats.putIfAbsent(participant, time);
			}
		}
		Map<Boat, Double> orderedWinners = finishedBoats.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry::getValue))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		orderedWinners.putAll(notFinishedBoats);
		return orderedWinners;
	}
	
	private void ValidateRaceIsSet() throws NoSetRaceException {
		if (this.getCurrentRace() == null) {
			throw new NoSetRaceException(Constants.NO_SET_RACE_MESSAGE);
		}
	}
	
	private void ValidateRaceIsEmpty() throws RaceAlreadyExistsException {
		if (this.getCurrentRace() != null) {
			throw new RaceAlreadyExistsException(Constants.RACE_ALREADY_EXISTS_MESSAGE);
		}
	}
}
