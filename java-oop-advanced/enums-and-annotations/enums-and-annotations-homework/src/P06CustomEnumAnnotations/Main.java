package P06CustomEnumAnnotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String category = reader.readLine();
	    EnumAnnotation annotation = null;
	    switch (category){
		    case "Rank":
		    	annotation = CardRank.class.getAnnotation(EnumAnnotation.class);
		    	break;
		    case "Suit":
			    annotation = CardSuit.class.getAnnotation(EnumAnnotation.class);
			    break;
	    }
	
	    System.out.println(String.format("Type = %s, Description = %s",
			    annotation.type(),annotation.descrition()));
    }
}
