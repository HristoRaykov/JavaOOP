package P13_SentenceExtractor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();

      String text = scanner.nextLine();

        String regex = "(.+?)(!|\\.|\\?)+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){
            if(matcher.group(1).contains(" " + key + " ")){
                System.out.println(matcher.group().trim());
            }
        }

    }
}
