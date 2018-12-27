import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P10GroupByGroup {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<Person> people = new ArrayList<>();
		
		String[] input;
		while (!(input = reader.readLine().split("\\s+"))[0].equals("END")) {
			
			String name = input[0].trim() + " " + input[1].trim();
			Integer group = Integer.valueOf(input[2]);
			Person person = new Person(name, group);
			people.add(person);
		}
		
		people.stream()
				.collect(Collectors.groupingBy(Person::getGroup))
				.entrySet()
				.stream()
				.collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream()
						.map(Person::getName)
						.collect(Collectors.joining(", "))))
				.forEach((key, value) -> System.out.printf("%s - %s\n", key, value));
		
		
	}
}

class Person {
	
	private String name;
	
	private Integer group;
	
	public Person(String name, Integer group) {
		this.name = name;
		this.group = group;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getGroup() {
		return group;
	}
	
	public void setGroup(Integer group) {
		this.group = group;
	}
}