package P01_CountSubstringElements;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();

        String searchWord = scanner.nextLine().toLowerCase();

        int count = 0;

        for (int i = 0; i < input.length() - searchWord.length(); i++) {
            String currentString = input.charAt(i) + "";

            for (int j = 1; j < searchWord.length(); j++) {
                currentString += input.charAt(i + j);
            }

            if(currentString.equals(searchWord)){
                count++;
            }
        }

        System.out.println(count);
    }
}
