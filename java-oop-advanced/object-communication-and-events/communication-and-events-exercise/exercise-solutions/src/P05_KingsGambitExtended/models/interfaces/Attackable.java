package P05_KingsGambitExtended.models.interfaces;

public interface Attackable {
	
	void respondToAttack();
	
	void addDefender(Defender defender);
	
	Defender getDefenderByName(String defenderName);
}
