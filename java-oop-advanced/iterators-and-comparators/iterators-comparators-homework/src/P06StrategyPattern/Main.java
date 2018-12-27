package P06StrategyPattern;

import P06StrategyPattern.comparators.AgeComparator;
import P06StrategyPattern.comparators.NameComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		Set<Person> nameSet = new TreeSet<>(new NameComparator());
		Set<Person> ageSet = new TreeSet<>(new AgeComparator());
		
		int n = Integer.valueOf(reader.readLine());
		
		while (n-->0){
			String[] params = reader.readLine().split("\\s+");
			Person person = new Person(params[0],Integer.valueOf(params[1]));
			nameSet.add(person);
			ageSet.add(person);
		}
		
		nameSet.forEach(System.out::println);
		ageSet.forEach(System.out::println);
	}
}
