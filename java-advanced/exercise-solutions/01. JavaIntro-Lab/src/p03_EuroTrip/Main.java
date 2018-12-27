package p03_EuroTrip;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double quantity = Double.parseDouble(scanner.nextLine());

        double priceInLv = quantity * 1.20;

       BigDecimal course = new BigDecimal("4210500000000");

       BigDecimal result = course.multiply(new BigDecimal(priceInLv));

        System.out.printf("%.2f marks", result);


    }
}
