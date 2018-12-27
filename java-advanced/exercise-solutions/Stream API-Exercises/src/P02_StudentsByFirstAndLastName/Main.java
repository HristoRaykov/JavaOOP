package P02_StudentsByFirstAndLastName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        LinkedHashSet<Student> students = new LinkedHashSet<>();

        while(!"END".equals(line)){
            String[] names = line.split(" ");
            Student student = new Student(names[0], names[1]);
            students.add(student);
            line = reader.readLine();
        }

        students.stream()
                .filter(student -> student.getName().compareTo(student.getLastName()) < 0)
                .forEach(student -> System.out.println(student.getName() + " " + student.getLastName()));
    }
    public static class Student{
        private String name;
        private String lastName;

        public Student(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }

        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }

    }
}
