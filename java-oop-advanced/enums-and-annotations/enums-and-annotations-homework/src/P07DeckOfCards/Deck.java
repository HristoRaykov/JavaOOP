package P07DeckOfCards;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Deck implements Iterable<Card> {
	
	private Set<Card> cards;
	
	public Deck() {
		cards = this.seedCards();
	}
	
	@Override
	public Iterator<Card> iterator() {
		return cards.iterator();
	}
	
	private Set<Card> seedCards() {
		Set<Card> cards = new TreeSet<>();
		for (CardSuit cardSuit:CardSuit.values()) {
			for (CardRank cardRank:CardRank.values()) {
				Card card = new Card(cardRank,cardSuit);
				cards.add(card);
			}
		}
		return cards;
	}
	
}
