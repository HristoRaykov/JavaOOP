package P06StrategyPattern.comparators;



import P06StrategyPattern.Person;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
	
	@Override
	public int compare(Person p1, Person p2) {
		if (p1.getName().length()==p2.getName().length()){
			return Character.compare(p1.getName().toLowerCase().charAt(0),p2.getName().toLowerCase().charAt(0));
		}
		
		return p1.getName().length()-p2.getName().length();
	}
	
}
