package P04_SortStudents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        LinkedHashSet<Student> students = new LinkedHashSet<>();

        while (!"END".equals(line)) {
            String[] names = line.split(" ");
            Student student = new Student(names[0], names[1]);
            students.add(student);
            line = reader.readLine();
        }


        Comparator<Student> compareByLastName = (student1, student2) -> student1.getLastName().compareTo(student2.getLastName());
        Comparator<Student> compareByName = (student1, student2) -> student2.getName().compareTo(student1.getName());

        students.stream()
                .sorted(compareByLastName.thenComparing(compareByName))
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
