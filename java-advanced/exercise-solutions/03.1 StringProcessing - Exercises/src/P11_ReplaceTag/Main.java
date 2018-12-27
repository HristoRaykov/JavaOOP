package P11_ReplaceTag;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        String line = scanner.nextLine();
        while (!"END".equals(line)) {
            sb.append(line).append("\n");
            line = scanner.nextLine();
        }

        Pattern pattern = Pattern.compile("(<a)[^>]*(>)[^</a>]*(</a>)");

        Matcher matcher = pattern.matcher(sb);

        //[URL href="/">Link</a>

        while (matcher.find()) {

            sb.replace(matcher.start(1), matcher.end(1), "[URL");
            sb.replace(matcher.start(2) + 2, matcher.end(2)+ 2, "]");
            sb.replace(matcher.start(3) + 2 , matcher.end(3) + 2, "[/URL]");

        }
        System.out.println(sb.toString());
    }
}
