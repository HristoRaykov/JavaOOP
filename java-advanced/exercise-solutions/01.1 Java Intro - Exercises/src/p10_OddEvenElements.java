import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by User on 22.8.2017 г..
 */
public class p10_OddEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[] commands = scanner.nextLine().split(" ");

        String command = commands[2];

        int count = Math.min(Integer.parseInt(commands[1]), numbers.length);

        ArrayList<Integer> result = new ArrayList<>();

        if("even".equals(command)){

            for (int i = 0; i < count; i++) {

                if(numbers[i] % 2 == 0){
                    result.add(numbers[i]);
                }
            }
        }else{
            for (int i = 0; i < count; i++) {

                if(numbers[i] % 2 != 0){
                    result.add(numbers[i]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Integer integer : result) {
            sb.append(integer + " ");
        }

        System.out.println(sb);
    }
}
