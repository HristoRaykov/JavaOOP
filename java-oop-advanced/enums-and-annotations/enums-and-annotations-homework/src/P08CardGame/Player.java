package P08CardGame;

import java.util.TreeSet;

public class Player implements Comparable<Player> {
	
	private String name;
	
	private TreeSet<Card> cards;
	
	public Player(String name) {
		this.name = name;
		cards = new TreeSet<>();
	}
	
	public String getName() {
		return name;
	}
	
	public Card getStrongestCard(){
		return this.cards.last();
	}
	
	public int getCurrentCardNumber(){
		return this.cards.size();
	}
	
	public void addCard(Card card){
		this.cards.add(card);
	}
	
	@Override
	public int compareTo(Player player) {
		
		return this.cards.last().getPower() - player.cards.last().getPower();
	}
}
