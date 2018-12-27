import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p01_ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String s : input) {
            stack.push(s);
        }

        while(stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }
    }
}
