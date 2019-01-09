package boatRacing.models.boats;

import boatRacing.models.Modelable;
import boatRacing.models.Race;

public interface Boat extends Modelable {
	
	double calculateRaceSpeed(Race race);

}
