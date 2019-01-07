package P05_KingsGambitExtended.models;



public class Footman extends BaseDefender  {
	
	
	private static final int FOOTMAN_HEALTH = 2;
	
	public Footman(String name, King king) {
		super(name, king);
		super.setHealth(FOOTMAN_HEALTH);
	}
	
	@Override
	public void defendKing() {
		System.out.println(String.format("Footman %s is panicking!",super.getName()));
	}
	
}
