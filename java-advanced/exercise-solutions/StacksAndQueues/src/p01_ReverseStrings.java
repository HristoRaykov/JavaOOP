import java.util.ArrayDeque;
import java.util.Scanner;

public class p01_ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> reversed = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentLetter = input.charAt(i);

            reversed.push(currentLetter + "");
        }

       while (reversed.size() > 0){
           System.out.print(reversed.pop());
       }
    }
}
