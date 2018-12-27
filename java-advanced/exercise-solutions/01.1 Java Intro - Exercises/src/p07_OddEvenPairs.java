import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by User on 22.8.2017 г..
 */
public class p07_OddEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if(input.length % 2 != 0){
            System.out.println("invalid length");
            return;
        }

        for (int i = 0; i < input.length; i +=2) {

            int a = input[i];
            int b = input[i + 1];

            if(a % 2 == 0 && b % 2 == 0){
                System.out.printf("%d, %d -> both are even\n", a, b);
            }else if(a % 2 != 0 && b % 2 != 0){
                System.out.printf("%d, %d -> both are odd\n", a, b);
            }else{
                System.out.printf("%d, %d -> different\n", a, b);

            }
        }
    }
}
