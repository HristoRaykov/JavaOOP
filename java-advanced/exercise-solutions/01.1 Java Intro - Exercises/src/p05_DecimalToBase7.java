import java.util.Scanner;

/**
 * Created by User on 22.8.2017 г..
 */
public class p05_DecimalToBase7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        String result = Integer.toString(num, 7);

        System.out.println(result);
    }
}
