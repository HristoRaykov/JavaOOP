import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class p03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeSet<String> compounds = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            Collections.addAll(compounds, input);
        }

        for (String compound : compounds) {
            System.out.printf("%s ", compound);
        }
    }
}
