package boatRacing.database;

import boatRacing.Utility.Constants;
import boatRacing.exeptions.DuplicateModelException;
import boatRacing.exeptions.NonExistantModelException;
import boatRacing.models.boatEngines.Engine;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoatEngineRepository implements Repository<Engine> {
	
	private Map<String, Engine> boatEnginesByModel;
	
	public BoatEngineRepository()
	{
		this.setBoatEnginesByModel(new LinkedHashMap<>());
	}
	
	private Map<String, Engine> getBoatEnginesByModel() {
		return this.boatEnginesByModel;
	}
	private void setBoatEnginesByModel(Map<String, Engine> boatEnginesByModel) {
		this.boatEnginesByModel = boatEnginesByModel;
	}
	
	
	@Override
	public void add(Engine item) throws DuplicateModelException {
		if (this.getBoatEnginesByModel().containsKey(item.getModel()))
		{
			throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
		}
		this.getBoatEnginesByModel().put(item.getModel(), item);
	}
	
	@Override
	public Engine getItem(String model) throws NonExistantModelException {
		if (!this.getBoatEnginesByModel().containsKey(model))
		{
			throw new NonExistantModelException(Constants.NON_EXISTANT_MODEL_MESSAGE);
		}
		
		return this.getBoatEnginesByModel().get(model);
	}
}
