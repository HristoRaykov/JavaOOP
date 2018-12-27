import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p08_MatrixShuffling {
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

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("END")) {
                break;
            }
            Pattern r = Pattern.compile("^swap(\\s+[0-9]+){4}$");
            Matcher m = r.matcher(command);

            if (m.find()) {
                int[] coupleA = new int[2];
                int[] coupleB = new int[2];

                String[] input = command.split(" ");

                coupleA[0] = Integer.parseInt(input[1]);
                coupleA[1] = Integer.parseInt(input[2]);
                coupleB[0] = Integer.parseInt(input[3]);
                coupleB[1] = Integer.parseInt(input[4]);

                try {
                    String firstValue = matrix[coupleA[0]][coupleA[1]];
                    String secondValue = matrix[coupleB[0]][coupleB[1]];

                    if (firstValue == null || secondValue == null) {
                        System.out.println("Invalid input!");
                        continue;
                    }

                    matrix[coupleB[0]][coupleB[1]] = firstValue;
                    matrix[coupleA[0]][coupleA[1]] = secondValue;


                } catch (Exception ex) {
                    System.out.println("Invalid input!");
                    continue;
                }

                for (String[] strings : matrix) {
                    for (String string : strings) {
                        System.out.print(string + " ");
                    }
                    System.out.println();
                }

            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}
