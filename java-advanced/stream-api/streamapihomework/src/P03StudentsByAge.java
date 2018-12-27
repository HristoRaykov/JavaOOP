import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P03StudentsByAge {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<StudentP03> students = new ArrayList<>();
		
		String[] input;
		while (!(input = reader.readLine().split("\\s+"))[0].equals("END")) {
			
			String name = input[0].trim() + " " + input[1].trim();
			int age = Integer.parseInt(input[2]);
			StudentP03 studentP03 = new StudentP03(name,age);
			students.add(studentP03);
		}
		
//				.sorted(Comparator.comparingInt(Map.Entry<String,Integer>::getValue).reversed())
		students.stream()
				.filter(studentP03 -> studentP03.getAge()>=18&& studentP03.getAge()<=24)
				.forEach(studentP03 -> System.out.println(String.format("%s %d", studentP03.getName(), studentP03.getAge())));
		
		
	}
}

class StudentP03 {
	
	private String name;
	
	private int age;
	
	public StudentP03(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
