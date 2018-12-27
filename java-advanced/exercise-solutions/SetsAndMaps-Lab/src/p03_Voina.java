import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class p03_Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstLine = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        LinkedHashSet<Integer> firstPlayer = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondPlayer = new LinkedHashSet<>();

        for (int i : firstLine) {
            firstPlayer.add(i);
        }
        for (int i : secondLine) {
            secondPlayer.add(i);
        }

        for (int i = 0; i < 50; i++) {

            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }
            int f = firstPlayer.iterator().next();
            firstPlayer.remove(f);
            int s = secondPlayer.iterator().next();
            secondPlayer.remove(s);

            if (f > s) {
                firstPlayer.add(f);
                firstPlayer.add(s);
            } else if (s > f) {
                secondPlayer.add(f);
                secondPlayer.add(s);
            }
        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }

    }
}
