import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p04_BasicQuequeOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] commands = scanner.nextLine().split(" ");

        int n = Integer.parseInt(commands[0]);
        int s = Integer.parseInt(commands[1]);
        int x = Integer.parseInt(commands[2]);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        if (queue.contains(x)) {
            System.out.println(true);
        } else {

            int smallest = Integer.MAX_VALUE;

            for (Integer integer : queue) {

                if (integer < smallest) {
                    smallest = integer;
                }
            }

            if (smallest == Integer.MAX_VALUE) {
                System.out.println(0);
            } else {
                System.out.println(smallest);
            }
        }
    }
}
