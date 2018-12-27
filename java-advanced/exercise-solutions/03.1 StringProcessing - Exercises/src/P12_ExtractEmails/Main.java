package P12_ExtractEmails;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String regex = "(^|\\s)[A-Za-z0-9]+[\\-_\\.]*[A-Za-z0-9]+@([A-Za-z]+[\\-]*[A-Za-z]+\\.)+[a-z]+(\\.|,|\\s|$)";

        String line = scanner.nextLine();
        while(!"end".equals(line)){

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);

            while(matcher.find()){
                if(matcher.group().endsWith(".") || matcher.group().endsWith(",")){
                    System.out.println(matcher.group().substring(0, matcher.group().length() - 1));
                }else{
                    System.out.println(matcher.group());
                }
            }
            line = scanner.nextLine();
        }
    }
}
