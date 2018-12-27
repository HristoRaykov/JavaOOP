import java.util.LinkedHashSet;
import java.util.Scanner;

public class p02_SetOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        LinkedHashSet<String> first = new LinkedHashSet<>();
        LinkedHashSet<String> second = new LinkedHashSet<>();

        for (int i = 0; i < Integer.parseInt(input[0]); i++) {
            first.add(scanner.nextLine());
        }
        for (int i = 0; i < Integer.parseInt(input[1]); i++) {
            second.add(scanner.nextLine());
        }

        for (String s : first) {
            if(second.contains(s)){
                System.out.printf("%s ", s);
            }
        }
    }
}
