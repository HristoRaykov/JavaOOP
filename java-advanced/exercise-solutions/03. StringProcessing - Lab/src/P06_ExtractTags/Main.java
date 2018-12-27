package P06_ExtractTags;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("<.*?>");

        String input = scanner.nextLine();
        while (!input.equals("END")){

            Matcher matcher = pattern.matcher(input);

            while(matcher.find()){
                for (int i = 0; i <= matcher.groupCount(); i++) {
                    System.out.println(matcher.group(i));

                }
            }
            input = scanner.nextLine();
        }

    }
}
