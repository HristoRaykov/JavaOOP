package P01CardSuit;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Card Suits:");
	    Arrays.stream(CardSuit.values())
			    .forEach(System.out::println);
    
    
    
    }
}
