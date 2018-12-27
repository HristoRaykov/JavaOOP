import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.TreeMap;

public class p05_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Double> stats = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

            double sum = 0;

            for (double grade : grades) {
                sum += grade;
            }

            stats.put(name, sum / grades.length);
        }

        for (String s : stats.keySet()) {
            System.out.printf("%s is graduated with %s\n", s,stats.get(s));

        }


    }
}
