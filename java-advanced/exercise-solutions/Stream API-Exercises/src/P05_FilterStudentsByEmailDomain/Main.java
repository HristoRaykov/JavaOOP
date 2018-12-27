package P05_FilterStudentsByEmailDomain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        LinkedHashSet<Student> students = new LinkedHashSet<>();

        while (!"END".equals(line)) {
            String[] names = line.split(" ");
            Student student = new Student(names[0], names[1], names[2]);
            students.add(student);
            line = reader.readLine();
        }

        students.stream()
                .filter(student -> student.getEmail().endsWith("@gmail.com"))
                .forEach(student -> System.out.println(student.getName() + " " + student.getLastName()));
    }

    public static class Student {
        private String name;
        private String lastName;
        private String email;

        public Student(String name, String lastName, String email) {
            this.name = name;
            this.lastName = lastName;
            this.email = email;
        }

        public String getEmail() {
            return email;
        }

        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }

    }
}
