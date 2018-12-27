import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P07ExcellentStudents {
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<StudentP07> students = new ArrayList<>();
		
		String[] input;
		while (!(input = reader.readLine().split("\\s+"))[0].equals("END")) {
			
			String name = input[0].trim() + " " + input[1].trim();
			List<Integer> grades = new ArrayList<>();
			for (int i = 2; i < input.length; i++) {
				grades.add(Integer.valueOf(input[i]));
			}
			
			StudentP07 studentP07 = new StudentP07(name,grades);
			students.add(studentP07);
		}
		
		students.stream()
				.filter(student -> student.getGrades().contains(6))
				.forEach(student -> System.out.println(student.getName()));
		
	}
}

class StudentP07 {
	
	private String name;
	
	private List<Integer> grades;
	
	public StudentP07(String name,  List<Integer> grades) {
		this.name = name;
		this.grades = grades;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Integer> getGrades() {
		return grades;
	}
	
	public void setGrades(List<Integer> grades) {
		this.grades = grades;
	}
}
