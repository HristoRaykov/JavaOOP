import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P02StudentsByFirstAndLastName {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<String> students = new ArrayList<>();
		
		String input;
		while (!(input = reader.readLine()).equals("END")) {
			students.add(input);
		}
		
		students.stream()
				.filter(fullname -> {
					String[] names = fullname.split("\\s+");
					String firstName = names[0];
					String lastName = names[1];
					return firstName.compareTo(lastName) <= 0;
				})
				.forEach(System.out::println);
	
	}
}
