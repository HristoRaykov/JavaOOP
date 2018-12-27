package P08CardGame;

public class Card implements Comparable<Card> {
	
	private CardRank cardRank;
	
	private CardSuit cardSuit;
	
	public Card(CardRank cardRank, CardSuit cardSuit) {
		this.cardRank = cardRank;
		this.cardSuit = cardSuit;
	}
	
	public CardRank getCardRank() {
		return cardRank;
	}
	
	public CardSuit getCardSuit() {
		return cardSuit;
	}
	
	public int getPower(){
		return this.cardRank.getPower()+this.cardSuit.getPower();
	}
	
	@Override
	public int compareTo(Card card) {
		return this.getPower()-card.getPower();
	}
	
	@Override
	public String toString() {
		return String.format("%s of %s",
				this.cardRank,this.cardSuit);
	}


}
