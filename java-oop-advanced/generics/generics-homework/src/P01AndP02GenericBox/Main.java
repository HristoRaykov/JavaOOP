package P01AndP02GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<Box> boxes = new ArrayList<>();
		
		int n = Integer.valueOf(reader.readLine());
		for (int i = 0; i < n; i++) {
			Box box = new Box<>(Integer.valueOf(reader.readLine()));
			boxes.add(box);
		}
		
		
		
		boxes.forEach(System.out::println);
		
	}


}
