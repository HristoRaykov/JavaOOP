import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p03_MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> someNumbers = new ArrayDeque<>();
        ArrayDeque<Integer> maxNumbers = new ArrayDeque<>();

        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            String[] commands = reader.readLine().split(" ");
            int command = Integer.parseInt(commands[0]);

            if (commands[0].equals("1")) {
                int number = Integer.parseInt(commands[1]);
                if (number >= maxValue) {
                    maxValue = number;
                    maxNumbers.push(maxValue);
                }
                someNumbers.push(number);

            } else if (commands[0].equals("2")) {
                int deletedItems = someNumbers.pop();
                if (deletedItems == maxValue) {
                    maxNumbers.pop();
                    if (!maxNumbers.isEmpty()) {
                        maxValue = maxNumbers.peek();
                    } else {
                        maxValue = Integer.MIN_VALUE;
                    }
                }

            } else if (commands[0].equals("3")) {

                System.out.println(maxNumbers.peek());
            }

        }
    }
}

