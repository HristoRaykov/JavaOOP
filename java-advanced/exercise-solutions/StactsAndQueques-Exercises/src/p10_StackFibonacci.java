import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class p10_StackFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<Long> stack = new ArrayDeque<>();

        stack.push(1L);
        stack.push(1L);

        for (int i = 2; i <= n; i++) {

            long f1 = stack.pop();
            long f0 = stack.pop();

            long currentNum = f1 + f0;

            stack.push(f1);
            stack.push(currentNum);
        }

        System.out.println(stack.peek());
    }
}
