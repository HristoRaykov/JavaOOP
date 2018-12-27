package P01_ReverseArray;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        reverseArray(input);
        System.out.println(Arrays.toString(input).replaceAll("[]\\[,]", ""));
    }

    public static void reverseArray(int[] input) {
        reverse(input, 0, input.length - 1);
    }
    public static void reverse(int[] x, int i, int j) {
        if (i < j) { //Swap
            int tmp = x[i];
            x[i] = x[j];
            x[j] = tmp;
            reverse(x, ++i, --j);//Recursive
        }
    }
}
