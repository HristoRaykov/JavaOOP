import java.math.BigDecimal;
import java.util.Scanner;

public class p01_RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal firstNum = new BigDecimal("0");
        BigDecimal second = new BigDecimal("0");

        try {firstNum = new BigDecimal(scanner.next());
        } catch (NumberFormatException nfe) {
            firstNum = new BigDecimal("0");
        }
        try {
            second = new BigDecimal(scanner.next());
        } catch (NumberFormatException nfe) {
            second = new BigDecimal("0");
        }finally {
            BigDecimal sum = firstNum.multiply(second);

            System.out.printf("%.2f", sum);
        }
    }
}
