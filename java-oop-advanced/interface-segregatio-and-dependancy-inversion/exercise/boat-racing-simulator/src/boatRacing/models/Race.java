package boatRacing.models;

import boatRacing.exeptions.DuplicateModelException;
import boatRacing.models.boats.Boat;

import java.util.List;

public interface Race {
	
    int getDistance();

    int getWindSpeed ();

    int getOceanCurrentSpeed();

    Boolean areMotorBoatsAllowed();

    void addParticipant(Boat boat) throws DuplicateModelException;

    List<Boat> getParticipants();
    
}
