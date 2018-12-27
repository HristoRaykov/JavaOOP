package P08CardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        Player player1 = new Player(reader.readLine());
        Player player2 = new Player(reader.readLine());
	    Set<Card> handedOutCards = new TreeSet<>();
        
        
        while (player1.getCurrentCardNumber()<5){
        	String[] input = reader.readLine().split(" of ");
	        Card card = null;
	        try {
		        card = new Card(CardRank.valueOf(input[0]), CardSuit.valueOf(input[1]));
	        } catch (IllegalArgumentException e) {
		        System.out.println("No such card exists.");
		        continue;
	        }
	        if (handedOutCards.contains(card)){
		        System.out.println("Card is not in the deck.");
	        }else {
		        player1.addCard(card);
		        handedOutCards.add(card);
	        }
        }
	
	    while (player2.getCurrentCardNumber()<5){
		    String[] input = reader.readLine().split(" of ");
		    Card card = null;
		    try {
			    card = new Card(CardRank.valueOf(input[0]), CardSuit.valueOf(input[1]));
		    } catch (IllegalArgumentException e) {
			    System.out.println("No such card exists.");
			    continue;
		    }
		    if (handedOutCards.contains(card)){
			    System.out.println("Card is not in the deck.");
		    }else {
			    player2.addCard(card);
			    handedOutCards.add(card);
		    }
	    }
     
	    if (player1.compareTo(player2)>=0){
		    System.out.println(String.format("%s wins with %s.",player1.getName(),player1.getStrongestCard()));
	    }else {
		    System.out.println(String.format("%s wins with %s.",player2.getName(),player2.getStrongestCard()));
	    }
    }
}
