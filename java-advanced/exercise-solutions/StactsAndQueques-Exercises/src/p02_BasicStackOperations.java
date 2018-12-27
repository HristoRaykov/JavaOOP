import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] commands = scanner.nextLine().split(" ");

        int n = Integer.parseInt(commands[0]);
        int s = Integer.parseInt(commands[1]);
        int x = Integer.parseInt(commands[2]);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stack.push(numbers[i]);
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (stack.contains(x)) {
            System.out.println(true);
        } else {

            int smallest = Integer.MAX_VALUE;

            for (Integer integer : stack) {

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
