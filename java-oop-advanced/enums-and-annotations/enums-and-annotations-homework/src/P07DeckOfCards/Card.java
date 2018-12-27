package P07DeckOfCards;

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
		if (this.getCardSuit().ordinal()-card.getCardSuit().ordinal()==0){
			return this.getCardRank().ordinal()-card.getCardRank().ordinal();
		}
		
		return this.getCardSuit().ordinal()-card.getCardSuit().ordinal();
	}
	
	@Override
	public String toString() {
		return String.format("%s of %s",
				this.cardRank,this.cardSuit);
	}


}
