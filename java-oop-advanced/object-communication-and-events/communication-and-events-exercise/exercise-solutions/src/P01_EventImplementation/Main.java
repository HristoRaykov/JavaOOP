package P01_EventImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	
        Dispatcher dispatcher = new Dispatcher();
        NameChangeListener handler = new Handler();
        dispatcher.addNameChangeListeners(handler);
        
        String name;
        while (!"End".equals(name=reader.readLine())){
        	dispatcher.setName(name);
        	dispatcher.fireNameChangeEvent();
        	
        }
        
    
    }
}
