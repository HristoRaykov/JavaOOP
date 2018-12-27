package P07EqualityLogic;

public class Person implements Comparable<Person> {
	
	private String name;
	
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public int compareTo(Person p) {
		if (this.getName().compareTo(p.getName())==0){
			return this.getAge()-p.getAge();
		}
		return this.getName().compareTo(p.getName());
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Person person = (Person) o;
		
		if (getAge() != person.getAge()) return false;
		return getName() != null ? getName().equals(person.getName()) : person.getName() == null;
	}
	
	@Override
	public int hashCode() {
		int result = getName() != null ? getName().hashCode() : 0;
		result = 31 * result + getAge();
		return result;
	}
}
