import java.util.Scanner;

/**
 * Created by User on 22.8.2017 г..
 */
public class p04_CalculateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double sqrt = Math.sqrt(c);
        double pow = ((a + b + c)/ sqrt);

        double f1 = Math.pow((a * a + b * b) / (a * a - b * b), pow);
        double f2 = Math.pow((a * a + b * b - c * c * c), (a - b));

        double abcAvg = (a + b + c) / 3;
        double f1f2Avg = (f1 + f2) / 2;

        double diff = Math.abs(abcAvg - f1f2Avg);

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, diff);
    }
}
