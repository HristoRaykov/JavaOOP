import java.util.Arrays;
import java.util.Scanner;

public class p03_3MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] size = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        
        int[][] matrice = new int[size[0]][size[1]];

        for (int row = 0; row < matrice.length; row++) {

            String[] input = scanner.nextLine().split(", ");

            for (int col = 0; col < matrice[0].length; col++) {
                matrice[row][col] = Integer.parseInt(input[col]);
            }
        }

        int sumMax = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < matrice.length - 1; row++) {
            for (int col = 0; col < matrice[0].length - 1 ; col++) {
            int currentSum = matrice[row][col] + matrice[row][col + 1]
                    + matrice[row + 1][col] + matrice[row + 1][col + 1];

                if(currentSum > sumMax){
                    sumMax = currentSum;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.println(matrice[startRow][startCol] + " " + matrice[startRow][startCol + 1]);
        System.out.println(matrice[startRow + 1][startCol] + " " + matrice[startRow + 1][startCol + 1]);
        System.out.println(sumMax);
        
    }
}
