package boatRacing.database;

import boatRacing.exeptions.DuplicateModelException;
import boatRacing.exeptions.NonExistantModelException;
import boatRacing.models.Modelable;

public interface Repository<T extends Modelable> {
	
    void add(T item) throws DuplicateModelException;

    T getItem(String model) throws NonExistantModelException;
    
}
