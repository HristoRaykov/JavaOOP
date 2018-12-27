import java.util.Scanner;

public class p01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int n = Integer.parseInt(input[0]);

        long[][] matrix = new long[n][n];

        if (input[1].equals("A")) {
            fillTheMatrixA(n, matrix);
        } else {
            fillTheMatrixB(n, matrix);
        }

        for (long[] ints : matrix) {
            for (long anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void fillTheMatrixA(int n, long[][] matrix) {
        int counter = 1;
        for (int col = 0; col < n ; col++) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = counter;
                counter++;
            }
            
        }
    }

    private static void fillTheMatrixB(int n, long[][] matrix) {

        int counter = 1;

        for (int col = 0; col < n; col++) {

            if (col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = n - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
    }
}
