import java.util.ArrayDeque;
import java.util.Scanner;

public class p04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length ; i++) {

            if(input[i] == '('){
                stack.push(i);
            }else if(input[i] == ')'){

                int start = stack.pop();

                for (int j = start; j <= i ; j++) {
                    System.out.print(input[j]);
                }
                System.out.println();
            }
        }

    }
}
