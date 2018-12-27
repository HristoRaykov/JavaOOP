import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p06_SequinceInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[size[0]][size[1]];

        for (int row = 0; row < size[0]; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < size[1]; col++) {
                matrix[row][col] = input[col];
            }
        }

        ArrayList<String> sequence = new ArrayList<>();

        int maxSequence = 0;
        int counter = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {

                String element = matrix[row][col];

                for (int r = row; r < row + 1; r++) {
                    for (int c = 0; c < matrix[row].length; c++) {

                        String currentElement = matrix[r][c];
                        if (element.equals(currentElement)) {
                            counter++;
                        }
                    }
                }
                if (counter >= maxSequence) {
                    maxSequence = counter;
                    counter = 0;

                    sequence.clear();

                    for (int i = 0; i < maxSequence; i++) {
                        sequence.add(element);
                    }
                }
                counter = 0;

                for (int i = row; i < matrix.length; i++) {
                    String currentElement = "";
                    try {
                        currentElement = matrix[i][i + col];
                    }catch(ArrayIndexOutOfBoundsException ex){
                        continue;
                    }

                    if (element.equals(currentElement)) {
                        counter++;
                    }

                }
                if (counter >= maxSequence) {
                    maxSequence = counter;
                    counter = 0;

                    sequence.clear();

                    for (int i = 0; i < maxSequence; i++) {
                        sequence.add(element);
                    }
                }
                counter = 0;

                for (int a = row; a < matrix.length; a++) {
                    String currentElement = matrix[a][col];

                    if (element.equals(currentElement)) {
                        counter++;
                    }
                }

                if (counter >= maxSequence) {
                    maxSequence = counter;
                    counter = 0;

                    sequence.clear();

                    for (int i = 0; i < maxSequence; i++) {
                        sequence.add(element);
                    }
                }
                counter = 0;
            }

        }

        System.out.println(sequence.toString().replace("[", "").replace("]", "") + ",");
    }
}