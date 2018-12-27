package P11_StudentsJoinedToSpecialties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        List<StudentSpecialty> studentSpecialtyList = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        while(!"Students:".equals(line)){
            String[] specialty = line.split("\\s+");

            StudentSpecialty ss = new StudentSpecialty(specialty[0] + " " + specialty[1], specialty[2]);
            studentSpecialtyList.add(ss);

            line = reader.readLine();
        }
        line = reader.readLine();

        while (!"END".equals(line)){
            String[] studentsInfo = line.split("\\s+");

            Student student = new Student(studentsInfo[1] + " " + studentsInfo[2], studentsInfo[0]);
            students.add(student);
            line = reader.readLine();
        }

        List<String> result = new ArrayList<>();

        studentSpecialtyList.forEach(studentSpecialty -> {
            String studentFac = studentSpecialty.getFacultyNumber();
                students.forEach(student -> {
                   if(student.getFacultyNumber().equals(studentFac)){
                       result.add(student.getName() + " " + studentSpecialty.getFacultyNumber() + " " + studentSpecialty.getSpecialtyName());
                   }
                });
        });

        result.stream().sorted(String::compareTo).forEach(System.out::println);
    }
    public static class StudentSpecialty{
        private String specialtyName;
        private String facultyNumber;

        public StudentSpecialty(String specialtyName, String facultyNumber) {
            this.specialtyName = specialtyName;
            this.facultyNumber = facultyNumber;
        }

        public String getSpecialtyName() {
            return specialtyName;
        }

        public String getFacultyNumber() {
            return facultyNumber;
        }

    }
    public static class Student{
        private String name;
        private String facultyNumber;

        public Student(String name, String facultyNumber) {
            this.name = name;
            this.facultyNumber = facultyNumber;
        }

        public String getName() {
            return name;
        }

        public String getFacultyNumber() {
            return facultyNumber;
        }
    }
}
