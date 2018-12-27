package p04_CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> employeeMap = new HashMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");

            Employee employee = null;

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            employeeMap.putIfAbsent(department, new ArrayList<>());

            switch (tokens.length) {
                case 6:
                    String email = tokens[4];
                    int age = Integer.parseInt(tokens[5]);

                    employee = new Employee(name, salary, position, department, email, age);
                    break;
                case 5:
                    try {
                        int age1 = Integer.parseInt(tokens[4]);

                        employee = new Employee(name, salary, position, department, age1);
                    } catch (NumberFormatException nfe) {
                        String email1 = tokens[4];

                        employee = new Employee(name, salary, position, department, email1);
                    }
                    break;
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;

            }
            employeeMap.get(department).add(employee);
        }

        employeeMap.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(
                        e2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                        e1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()
                )).limit(1)
                .forEach(e -> {
                    System.out.println(String.format("Highest Average Salary: %s", e.getKey()));
                    e.getValue().stream()
                            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())).collect(Collectors.toList())
                            .forEach(System.out::println);
                });

    }
}
