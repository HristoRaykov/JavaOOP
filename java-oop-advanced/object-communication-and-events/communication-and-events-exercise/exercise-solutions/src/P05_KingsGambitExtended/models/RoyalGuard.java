package P05_KingsGambitExtended.models;


public class RoyalGuard extends BaseDefender {
	
	private static final int ROYALGUARD_HEALTH = 3;
	
	public RoyalGuard(String name, King king) {
		super(name, king);
		super.setHealth(ROYALGUARD_HEALTH);
	}
	
	@Override
	public void defendKing() {
		System.out.println(String.format("Royal Guard %s is defending!",super.getName()));
	}
}
