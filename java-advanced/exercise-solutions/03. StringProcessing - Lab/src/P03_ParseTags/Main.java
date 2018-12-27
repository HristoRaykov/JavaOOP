package P03_ParseTags;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String upcaseStart = "<upcase>";
        String upcaseEnd = "</upcase>";

        while(input.contains(upcaseStart)){

            int startIndex = input.indexOf(upcaseStart);
            int endIndex = input.indexOf(upcaseEnd);

            String textForReplace = input.substring(startIndex + upcaseStart.length(), endIndex);
            String upperCase = textForReplace.toUpperCase();

            input = input.replaceFirst(textForReplace, upperCase);
            input = input.replaceFirst(upcaseStart, "");
            input = input.replaceFirst(upcaseEnd, "");
        }

        System.out.println(input);
    }
}
