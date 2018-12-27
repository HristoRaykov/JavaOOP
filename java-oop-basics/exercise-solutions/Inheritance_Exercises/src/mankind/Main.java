package mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] studentInfo = scanner.nextLine().split(" ");
        String[] workerInfo = scanner.nextLine().split(" ");

        try {
            String studentFirstName = studentInfo[0];
            String studentLastName = studentInfo[1];
            String studentFacultyNumber = studentInfo[2];

            Student student = new Student(studentFirstName, studentLastName, studentFacultyNumber);

            String workerFirstName = workerInfo[0];
            String workerLastName = workerInfo[1];
            double weekSalary = Double.parseDouble(workerInfo[2]);
            double workHours = Double.parseDouble(workerInfo[3]);

            Worker worker = new Worker(workerFirstName, workerLastName, weekSalary, workHours);

            System.out.println(student);
            System.out.println(worker);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }

    }
}
