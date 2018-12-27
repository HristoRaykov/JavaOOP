import java.util.Scanner;

public class CalculateTriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double base = scanner.nextDouble();
        double height = scanner.nextDouble();

        System.out.printf("Area = %.2f", calculateTriangleArea(base, height));
    }

    private static double calculateTriangleArea(double base, double height) {
        return (base * height) / 2;
    }
}
