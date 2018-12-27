import java.util.Scanner;

/**
 * Created by User on 22.8.2017 г..
 */
public class p06_Base7ToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int result = makeDecimal(input, 7);

        System.out.println(result);
    }
    public static int makeDecimal(String value, int base) {
        // exit from recursion
        if (value.length() < 1)
            return 0;

        //parsing last character of string
        int charValue = Integer.parseInt(value.substring(value.length() - 1), base);

        //calling recursion for string without last character
        return makeDecimal(value.substring(0, value.length() - 1), base) * base + charValue;
    }
}
