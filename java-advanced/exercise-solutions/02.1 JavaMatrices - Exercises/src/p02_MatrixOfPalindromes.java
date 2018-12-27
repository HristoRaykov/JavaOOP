import java.util.Scanner;

public class p02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = String.valueOf(letters[row])
                        .concat(String.valueOf(letters[row + col]))
                        .concat(String.valueOf(letters[row]));
            }
        }

        for (String[] ints : matrix) {
            for (String anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
