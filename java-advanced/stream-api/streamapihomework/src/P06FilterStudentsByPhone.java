import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P06FilterStudentsByPhone {
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<StudentP06> students = new ArrayList<>();
		
		String[] input;
		while (!(input = reader.readLine().split("\\s+"))[0].equals("END")) {
			
			String name = input[0].trim() + " " + input[1].trim();
			String phone = input[2];
			StudentP06 studentP06 = new StudentP06(name,phone);
			students.add(studentP06);
		}
		
		students.stream()
				.filter(studentP06 -> studentP06.getPhone().startsWith("02")||studentP06.getPhone().startsWith("+3592"))
				.forEach(studentP06 -> System.out.println(studentP06.getName()));
		
	}
}

class StudentP06 {
	
	private String name;
	
	private String phone;
	
	public StudentP06(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
}

