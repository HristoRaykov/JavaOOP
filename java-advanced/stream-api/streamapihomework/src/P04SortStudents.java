import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P04SortStudents {
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<String> students = new ArrayList<>();
		
		String input;
		while (!(input = reader.readLine()).equals("END")) {
			students.add(input);
		}
		
		students.stream()
				.sorted((fullName1,fullName2)   -> {
					String[] names1 = fullName1.split("\\s+");
					String firstName1 = names1[0];
					String lastName1 = names1[1];
					String[] names2 = fullName2.split("\\s+");
					String firstName2 = names2[0];
					String lastName2 = names2[1];
					if (lastName1.compareTo(lastName2)==0){
						return firstName2.compareTo(firstName1);
					}else{
						return lastName1.compareTo(lastName2);
					}
				})
				.forEach(System.out::println);
		
	}
}
