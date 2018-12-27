package P03_StudentsByAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        LinkedHashSet<Student> students = new LinkedHashSet<>();

        while (!"END".equals(line)) {
            String[] names = line.split(" ");
            Student student = new Student(names[0], names[1], Integer.parseInt(names[2]));
            students.add(student);
            line = reader.readLine();
        }

        students.stream()
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 24)
                .forEach(student -> System.out.println(student.getName() + " " + student.getLastName() + " " + student.getAge()));
    }

    public static class Student {
        private String name;
        private String lastName;
        private int age;

        public Student(String name, String lastName, int age) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }
    }

}
