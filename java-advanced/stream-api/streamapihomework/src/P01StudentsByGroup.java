import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class P01StudentsByGroup {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> students = new HashMap<>();
		
		String[] input;
		while (!(input = reader.readLine().split("\\s+"))[0].equals("END")) {
			
			String name = input[0] + " " + input[1];
			int group = Integer.parseInt(input[2]);
			
			students.putIfAbsent(name,0);
			students.put(name,group);
			
		}
		
		students.entrySet().stream()
				.filter(entry -> entry.getValue()==2)
				.sorted(Comparator.comparing(Map.Entry::getKey))
				.forEach(entry -> System.out.println(entry.getKey()));
		
	}
}
