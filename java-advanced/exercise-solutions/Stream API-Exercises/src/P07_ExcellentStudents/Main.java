package P07_ExcellentStudents;

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

            for (int i = 2; i < names.length; i++) {
                grades.add(Integer.parseInt(names[i]));
            }
            Student student = new Student(names[0], names[1], grades);
            students.add(student);

            line = reader.readLine();
        }
        students.stream()
                .filter(student -> student.getGrades().contains(6))
                .forEach(student -> System.out.println(student.getName() + " " + student.getLastName()));

    }
    public static class Student {
        private String name;
        private String lastName;
        private List<Integer> grades;

        public Student(String name, String lastName, List<Integer> grades) {
            this.name = name;
            this.lastName = lastName;
            this.grades = grades;
        }

        public void setGrades(List<Integer> grades){
            this.grades.addAll(grades);
        }
        public List<Integer> getGrades() {
            return grades;
        }

        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }

    }
}
