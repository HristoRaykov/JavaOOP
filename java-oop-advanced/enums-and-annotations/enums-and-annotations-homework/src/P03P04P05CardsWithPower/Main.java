package P03P04P05CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
        Card card1 =  new Card(CardRank.valueOf(reader.readLine()), CardSuit.valueOf(reader.readLine()));
        Card card2 =  new Card(CardRank.valueOf(reader.readLine()), CardSuit.valueOf(reader.readLine()));
        
	
	    if (card1.compareTo(card2)>0) {
		    System.out.println(card1);
	    } else {
		    System.out.println(card2);
	    }
    }
}
