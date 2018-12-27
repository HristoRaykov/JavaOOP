import java.util.Arrays;
import java.util.Scanner;

public class p03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        int diagonal1 = 0;
        int diagonal2 = 0;

        for (int row = 0; row < n; row++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < n; col++) {
                matrix[row][col] = input[col];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {

                    if(row == col && row == i){
                        diagonal1 += matrix[row][col];
                    }
                    if(row == i && col == n - 1 - i){
                        diagonal2 += matrix[row][col];
                    }
                }
            }
        }

        System.out.println(Math.abs(diagonal1 - diagonal2));
    }
}
