package boatRacing.database;

import boatRacing.Utility.Constants;
import boatRacing.exeptions.DuplicateModelException;
import boatRacing.exeptions.NonExistantModelException;
import boatRacing.models.boats.Boat;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoatRepository implements Repository<Boat> {
	
    private Map<String, Boat> boatsByModel;

    public BoatRepository()
    {
        this.setBoatsByModel(new LinkedHashMap<>());
    }

    private Map<String, Boat> getBoatsByModel() {
        return this.boatsByModel;
    }
	
	private void setBoatsByModel(Map<String, Boat> boatsByModel) {
        this.boatsByModel = boatsByModel;
    }

    @Override
    public void add(Boat item) throws DuplicateModelException {
        if (this.getBoatsByModel().containsKey(item.getModel()))
        {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }
        this.getBoatsByModel().put(item.getModel(), item);
    }
    
	
	@Override
    public Boat getItem(String model) throws NonExistantModelException {
        if (!this.getBoatsByModel().containsKey(model))
        {
            throw new NonExistantModelException(Constants.NON_EXISTANT_MODEL_MESSAGE);
        }

        return this.getBoatsByModel().get(model);
    }

}
