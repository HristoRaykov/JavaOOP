package P09_StudentsEnrolledIn2014And2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        List<Student> students = new ArrayList<>();

        while (!"END".equals(line)) {

            String[] names = line.split(" ");
            List<Integer> grades = new ArrayList<>();

            for (int i = 1; i < names.length; i++) {
                grades.add(Integer.parseInt(names[i]));
            }
            Student student = new Student(names[0], grades);
            students.add(student);

            line = reader.readLine();
        }
        students.stream().filter(student -> {
            if (student.getFacultyNumber().endsWith("14") || student.getFacultyNumber().endsWith("15")) return true;
            else return false;
        }).forEach(student -> System.out.println(String.join(" ", student.getGrades().toString().replaceAll("[\\[\\],]", ""))));

    }

    public static class Student {
        private String facultyNumber;
        private List<Integer> grades;

        public Student(String facultyNumber, List<Integer> grades) {
            this.facultyNumber = facultyNumber;
            this.grades = grades;
        }

        public String getFacultyNumber() {
            return facultyNumber;
        }

        public List<Integer> getGrades() {
            return grades;
        }
    }
}
