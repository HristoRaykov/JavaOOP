package P04_SeriesOfLetters;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String lastLetter = String.valueOf(input.charAt(0));

        StringBuilder sb = new StringBuilder();
        sb.append(lastLetter);

        for (int i = 1; i < input.length(); i++) {

            String currentLetter = String.valueOf(input.charAt(i));

            if(!currentLetter.equals(lastLetter)){
                sb.append(currentLetter);
            }
            lastLetter = currentLetter;
        }
        System.out.println(sb.toString());

    }
}
