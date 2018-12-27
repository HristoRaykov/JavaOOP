package P10ToP13InfernoInfinity;

import java.util.Comparator;

public class WeaponComparator implements Comparator<Weapon> {
	
	
	@Override
	public int compare(Weapon weapon1, Weapon weapon2) {
		return weapon1.getItemLevel() - weapon2.getItemLevel() > 0 ? 1 :
				(weapon1.getItemLevel() - weapon2.getItemLevel()==0 ? 0 : -1);
	}
}
