import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p07_PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();

        ArrayDeque<Character> words = new ArrayDeque<>();

        for (Character letter : input) {
            words.offer(letter);
        }

        boolean isPalindrome = true;

        while(words.size() > 1){

            char first = words.pop();
            char second = words.pollLast();

            if(first != second){
                isPalindrome = false;
            }
        }

        System.out.println(isPalindrome);
    }
}
