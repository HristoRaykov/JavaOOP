package P10_MatchPhoneNumber;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        while(!line.equals("end")){

            Pattern pattern = Pattern.compile("^\\+359( |-)2(\\1)[0-9]{3}(\\1)[0-9]{4}$");
            Matcher matcher = pattern.matcher(line);
            if(matcher.find()){
                System.out.println(line);
            }
            line = scanner.nextLine();
        }
    }
}
