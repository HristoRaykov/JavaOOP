package P07_ValidUsernames;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String pattern = "^[\\w-]{3,16}$";

         List<String> results = new ArrayList<>();

        String line = scanner.nextLine();
        while(!"END".equals(line)){

            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(line);

            if(matcher.find()) {
                results.add("valid");
            }else {
                results.add("invalid");
            }

            line = scanner.nextLine();
        }

        if(results.contains("valid")){
            for (Object result : results) {
                System.out.println(result);
            }
        }
    }
}
