import java.util.Scanner;
import java.util.TreeMap;

public class p10_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] line = scanner.nextLine().toCharArray();

        TreeMap<Character, Integer> results = new TreeMap<>();

        for (char c : line) {
            results.putIfAbsent(c, 0);

            results.put(c, results.get(c) + 1);
        }

        for (Character character : results.keySet()) {
            System.out.printf("%c: %d time/s%n", character, results.get(character));
        }
    }
}
