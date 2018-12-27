import java.util.Arrays;
import java.util.Scanner;

public class p01_ReadSortPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        String[] array = new String[count];

        for (int i = 0; i < count; i++) {
            array[i] = scanner.nextLine();
        }

        Arrays.sort(array);

        for (String s : array) {
            System.out.println(s);
        }
    }
}
