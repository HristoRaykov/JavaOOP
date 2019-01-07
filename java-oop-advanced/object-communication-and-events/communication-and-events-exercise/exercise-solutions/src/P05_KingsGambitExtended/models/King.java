package P05_KingsGambitExtended.models;


import P05_KingsGambitExtended.models.interfaces.Attackable;
import P05_KingsGambitExtended.models.interfaces.Defender;
import P05_KingsGambitExtended.models.interfaces.Killable;

import java.util.LinkedHashMap;
import java.util.Map;

public class King extends BaseUnit implements Attackable, Killable {
	
	private Map<String, Defender> defenders;
	
	
	public King(String name) {
		super(name);
		this.defenders = new LinkedHashMap<>();
	}
	
	@Override
	public void respondToAttack() {
		System.out.println(String.format("King %s is under attack!",super.getName()));
		for (Defender defender : defenders.values()) {
			defender.defendKing();
		}
	}
	
	@Override
	public void addDefender(Defender defender) {
		this.defenders.putIfAbsent(defender.getName(),defender);
	}
	
	@Override
	public void removeDefender(String defenderName) {
		this.defenders.remove(defenderName);
	}
	
	@Override
	public Defender getDefenderByName(String defenderName){
		return this.defenders.get(defenderName);
	}
}
