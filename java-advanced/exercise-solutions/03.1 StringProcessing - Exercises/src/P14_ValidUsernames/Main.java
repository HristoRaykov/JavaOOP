package P14_ValidUsernames;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String users = scanner.nextLine();

        Pattern pattern = Pattern.compile("( |\\\\|/|\\)|\\()([a-zA-Z]\\w+)");
        Matcher matcher = pattern.matcher(users);

        List<String> correctUsers = new ArrayList<>();

        while (matcher.find()) {
            correctUsers.add(matcher.group(2));
        }

        int index = -1;
        int maxSum = 0;
        for (int i = 0; i < correctUsers.size() - 1; i++) {

            if (correctUsers.get(i).length() + correctUsers.get(i + 1).length() > maxSum) {
                maxSum = correctUsers.get(i).length() + correctUsers.get(i + 1).length();
                index = i;
            }
        }
        try{
            System.out.println(correctUsers.get(index));
            System.out.println(correctUsers.get(index + 1));
        }catch (Exception ex){

        }

    }
}
