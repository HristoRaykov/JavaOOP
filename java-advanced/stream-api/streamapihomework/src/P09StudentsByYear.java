import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P09StudentsByYear {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<StudentP09> students = new ArrayList<>();
		
		String[] input;
		while (!(input = reader.readLine().split("\\s+"))[0].equals("END")) {
			
			String facNum = input[0].trim();
			List<Integer> grades = Arrays.stream(input)
					.skip(1)
					.map(Integer::valueOf)
					.collect(Collectors.toList());
			
			
			StudentP09 student = new StudentP09(facNum, grades);
			students.add(student);
		}
		
		students.stream()
				.filter(student -> student.getFacNum().endsWith("14")||student.getFacNum().endsWith("15"))
				.forEach(student -> System.out.println(student.getGrades().toString().replaceAll("[\\[\\],]","")));
	}
}


class StudentP09 {
	
	private String facNum;
	
	private List<Integer> grades;
	
	public StudentP09(String facNum, List<Integer> grades) {
		this.facNum = facNum;
		this.grades = grades;
	}
	
	public String getFacNum() {
		return facNum;
	}
	
	public void setFacNum(String facNum) {
		this.facNum = facNum;
	}
	
	public List<Integer> getGrades() {
		return grades;
	}
	
	public void setGrades(List<Integer> grades) {
		this.grades = grades;
	}
}


