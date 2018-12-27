import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P11StudentsJoinedToSpecialties {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<StudentSpecialty> specialties = new ArrayList<>();
		List<StudentP11> students = new ArrayList<>();
		
		String input;
		String[] tokens;
		while (!(input = reader.readLine()).equals("Students:")) {
			tokens = input.split("\\s+");
			StudentSpecialty studentSpecialty = new StudentSpecialty(tokens[0] + " " + tokens[1], tokens[2]);
			specialties.add(studentSpecialty);
		}
		while (!(input = reader.readLine()).equals("END")) {
			tokens = input.split("\\s+");
			StudentP11 student = new StudentP11(tokens[1] + " " + tokens[2], tokens[0]);
			students.add(student);
		}
		
		List<String> joined = new ArrayList<>();
		
		specialties.stream()
				.forEach(specialty -> students.stream()
						.filter(student -> student.getFacultyNumber().equals(specialty.getFacultyNumber()))
						.forEach(student ->
								joined.add(student.getStudentName() + " " +
										student.getFacultyNumber() + " " + specialty.getSpecialtyName()))
				);
		
		
		joined.stream()
				.sorted(String::compareTo)
				.forEach(System.out::println);
	}
	
}

class StudentSpecialty {
	
	private String specialtyName;
	
	private String facultyNumber;
	
	public StudentSpecialty(String specialtyName, String facultyNumber) {
		this.specialtyName = specialtyName;
		this.facultyNumber = facultyNumber;
	}
	
	public String getSpecialtyName() {
		return specialtyName;
	}
	
	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}
	
	public String getFacultyNumber() {
		return facultyNumber;
	}
	
	public void setFacultyNumber(String facultyNumber) {
		this.facultyNumber = facultyNumber;
	}
}

class StudentP11 {
	
	private String studentName;
	
	private String facultyNumber;
	
	public StudentP11(String studentName, String facultyNumber) {
		this.studentName = studentName;
		this.facultyNumber = facultyNumber;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getFacultyNumber() {
		return facultyNumber;
	}
	
	public void setFacultyNumber(String facultyNumber) {
		this.facultyNumber = facultyNumber;
	}
}