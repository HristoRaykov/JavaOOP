import java.util.HashMap;
import java.util.Scanner;

public class p07_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> users = new HashMap<>();

        while(true){

            String secondLine = scanner.nextLine();
            if(secondLine.equals("stop")){
                break;
            }
            String firstLine = scanner.nextLine().toLowerCase();

            String sbs = firstLine.substring(firstLine.length() - 3, firstLine.length());

            if(!(sbs.equals(".us") || sbs.equals(".uk") || sbs.equals("com"))){
                users.put(secondLine, firstLine);
            }
        }

        for (String s : users.keySet()) {
            System.out.printf("%s -> %s\n", s, users.get(s));
        }
    }
}
