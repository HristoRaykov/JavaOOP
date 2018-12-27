import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P05FilterStudentsByEmailDomain {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<StudentP05> students = new ArrayList<>();
		
		String[] input;
		while (!(input = reader.readLine().split("\\s+"))[0].equals("END")) {
			
			String name = input[0].trim() + " " + input[1].trim();
			String email = input[2];
			StudentP05 studentP05 = new StudentP05(name,email);
			students.add(studentP05);
		}
		
		students.stream()
				.filter(studentP05 -> studentP05.getEmail().endsWith("@gmail.com"))
				.forEach(studentP05 -> System.out.println(studentP05.getName()));
		
	}
}

class StudentP05 {
	
	private String name;
	
	private String email;
	
	public StudentP05(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}