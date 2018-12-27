package P07EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		Set<Person> treeSet = new TreeSet<>();
		Set<Person> hashSet = new HashSet<>();
		
		int n = Integer.valueOf(reader.readLine());
		
		while (n-->0){
			String[] params = reader.readLine().split("\\s+");
			Person person = new Person(params[0],Integer.valueOf(params[1]));
			treeSet.add(person);
			hashSet.add(person);
		}
		
		System.out.println(treeSet.size());
		System.out.println(hashSet.size());
	}
}
