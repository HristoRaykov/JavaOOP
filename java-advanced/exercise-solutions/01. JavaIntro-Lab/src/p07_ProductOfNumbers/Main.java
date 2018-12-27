package p07_ProductOfNumbers;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        BigInteger result = BigInteger.ONE;

        int start = num1;

        do{
            BigInteger currentNum = new BigInteger("" + num1);
            result = result.multiply(currentNum);

            num1++;

        }while(num1 <= num2);

        System.out.printf("product[%d..%d] = %d", start, num2, result);
    }
}
