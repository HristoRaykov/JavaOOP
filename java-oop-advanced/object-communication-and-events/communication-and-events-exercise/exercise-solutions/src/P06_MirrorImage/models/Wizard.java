package P06_MirrorImage.models;

import java.util.Map;

public interface Wizard {
	
	int getId();
	
	Map<Integer, Wizard> getWizards();
	
	void castReflection();
	
	void castFireBall();
	
	
	
}
