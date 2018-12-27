package P03P04P05CardsWithPower;

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
		return String.format("Card name: %s of %s; Card power: %d",
				this.cardRank,this.cardSuit,this.getPower());
	}


}
