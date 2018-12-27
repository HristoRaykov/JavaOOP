import java.util.ArrayDeque;
import java.util.Scanner;

public class p03_DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();

        if(num == 0){
            System.out.println(0);
            return;
        }

        while (num != 0){

            stack.push(String.valueOf(num % 2));

            num /= 2;
        }

        while(stack.size() > 0){
            System.out.print(stack.pop());
        }
    }
}
