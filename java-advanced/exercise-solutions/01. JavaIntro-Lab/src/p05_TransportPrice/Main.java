package p05_TransportPrice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int distance = Integer.parseInt(scanner.nextLine());
        String shift = scanner.nextLine();

        double price = 0;

        if (distance < 20) {
            if (shift.equals("day")) {
                price = distance * 0.79 + 0.70;
            } else {
                price = distance * 0.90 + 0.70;
            }
        } else if (distance >= 20 && distance < 100) {
            price = 0.09 * distance;
        } else {
            price = 0.06 * distance;
        }

        System.out.printf("%.2f", price);
    }
}
