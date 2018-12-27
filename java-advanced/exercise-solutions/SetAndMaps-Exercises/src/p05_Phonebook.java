import java.util.HashMap;
import java.util.Scanner;

public class p05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> phonebook = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")) {

            String[] entry = input.split("-");
            phonebook.put(entry[0], entry[1]);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("stop")) {

            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s\n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.\n", input);
            }

            input = scanner.nextLine();
        }
    }
}
