import java.util.ArrayList;
import java.util.Scanner;

public class p07_CollectCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<ArrayList<Character>> matrix = new ArrayList<ArrayList<Character>>();

        matrix.add(0, new ArrayList<Character>());
        matrix.add(1, new ArrayList<Character>());
        matrix.add(2, new ArrayList<Character>());
        matrix.add(3, new ArrayList<Character>());

        for (int row = 0; row < 4; row++) {
            char[] input = scanner.nextLine().toCharArray();
            for (int col = 0; col < input.length; col++) {
                matrix.get(row).add(input[col]);
            }
        }
        char[] commands = scanner.nextLine().toCharArray();

        int[] index = new int[2];
        index[0] = 0;
        index[1] = 0;

        int coins = 0;
        int walls = 0;

        for (int i = 0; i < commands.length; i++) {

            char currentCommand = commands[i];

            if (currentCommand == 'V') {

                try {
                    char symb = matrix
                            .get(index[0] + 1)
                            .get(index[1]);
                    index[0] = index[0] + 1;

                    if (symb == '$') {
                        coins++;
                    }
                } catch (Exception ex) {
                    walls++;
                }
            } else if (currentCommand == '^') {

                try {
                    char symb = matrix.get(index[0] - 1).get(index[1]);
                    index[0] = index[0] - 1;

                    if (symb == '$') {
                        coins++;
                    }
                } catch (Exception ex) {
                    walls++;
                }
            }
            else if( currentCommand == '>'){

                try {
                    char symb = matrix.get(index[0]).get(index[1] + 1);
                    index[1] = index[1] + 1;

                    if (symb == '$') {
                        coins++;
                    }
                } catch (Exception ex) {
                    walls++;
                }
            }
            else if(currentCommand == '<'){
                try {
                    char symb = matrix.get(index[0]).get(index[1] - 1);
                    index[1] = index[1] - 1;

                    if (symb == '$') {
                        coins++;
                    }
                } catch (Exception ex) {
                    walls++;
                }
            }
        }
        System.out.println("Coins = " + coins);
        System.out.println("Walls = " + walls);
    }
}
