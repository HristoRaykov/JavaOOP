package P05ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		List<Person> people = new ArrayList<>();
		
		while (!"END".equals(line = reader.readLine())) {
			String[] params = line.split("\\s+");
			Person person = new Person(params[0],Integer.valueOf(params[1]),params[2]);
			people.add(person);
		}
		int index = Integer.valueOf(reader.readLine());
		Person person = people.get(index-1);
		long numberOfEqualPeople = people.stream()
				.filter(p -> p.compareTo(person)==0)
				.count();
		long numberOfNotEqualPeople = people.stream()
				.filter(p -> p.compareTo(person)!=0)
				.count();
		
		if (numberOfEqualPeople>1) {
			System.out.println(String.format("%d %d %d", numberOfEqualPeople, numberOfNotEqualPeople, people.size()));
		} else {
			System.out.println("No matches");
		}
	}
}
