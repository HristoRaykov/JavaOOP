import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class P07PredicateForNames {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(reader.readLine());
		String[] input = reader.readLine().split("\\s+");
		
		Predicate<String> nameLength = name -> name.length()<=length;
		
		for (String name : input) {
			if (nameLength.test(name)) {
				System.out.println(name);
			}
		}
		
	}
}
