import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class p08_BalancedParenthees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();

        if (input.length % 2 != 0) {
            System.out.println("NO");
            return;
        }

        Deque<Character> openBraces = new ArrayDeque<>();

        for (char brace : input) {

            if (brace == '{' || brace == '[' || brace == '(') {
                openBraces.push(brace);
            } else {
                char currentBraced = openBraces.pop();

                if (brace == '}') {
                    brace = '{';
                }
                if (brace == ']') {
                    brace = '[';
                }
                if (brace == ')') {
                    brace = '(';
                }

                if (brace != currentBraced) {
                    System.out.println("NO");
                    return;
                }

            }
        }
        System.out.println("YES");

    }
}
