import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P08WeakStudents {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<StudentP08> students = new ArrayList<>();
		
		String[] input;
		while (!(input = reader.readLine().split("\\s+"))[0].equals("END")) {
			
			String name = input[0].trim() + " " + input[1].trim();
			List<Integer> grades = Arrays.stream(input)
					.skip(2)
					.map(Integer::valueOf)
					.collect(Collectors.toList());
			
			
			StudentP08 student = new StudentP08(name, grades);
			students.add(student);
		}
		
		students.stream()
				.filter(student -> student.getGrades().stream().filter(grade->grade<=3).count()>=2)
				.forEach(student -> System.out.println(student.getName()));
	}
}


class StudentP08 {
	
	private String name;
	
	private List<Integer> grades;
	
	public StudentP08(String name, List<Integer> grades) {
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

