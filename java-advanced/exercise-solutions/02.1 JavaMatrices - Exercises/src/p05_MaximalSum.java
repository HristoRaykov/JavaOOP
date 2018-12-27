import java.util.Arrays;
import java.util.Scanner;

public class p05_MaximalSum {
    public static void main(String[] args) {

        start();

    }
    public static void start(){
        readMatrix();
    }
    private static void readMatrix() {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[size[0]][size[1]];

        for (int row = 0; row < size[0]; row++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < size[1]; col++) {
                matrix[row][col] = input[col];
            }
        }
        getMaxSum(matrix);

    }
    private static void getMaxSum(int[][] matrix) {
        long maxSum = Long.MIN_VALUE;
        int[] index = new int[2];

        int sum = 0;
        int currentRow = 0;
        int currentCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                currentRow = row;
                currentCol = col;

                try {
                    for (int r = currentRow; r < currentRow + 3; r++) {
                        for (int c = currentCol; c < currentCol + 3; c++) {
                            sum += matrix[r][c];
                        }
                    }
                    if (sum > maxSum) {
                        maxSum = sum;
                        index[0] = currentRow;
                        index[1] = currentCol;
                    }
                    sum = 0;
                } catch (IndexOutOfBoundsException ex) {
                    sum = 0;
                }
            }
        }
        print(matrix, maxSum, index);
    }
    private static void print(int[][] matrix, long maxSum, int[] index) {

        System.out.println("Sum = " + maxSum);

        for (int i = index[0]; i < index[0] + 3; i++) {
            for (int j = index[1]; j < index[1] + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
