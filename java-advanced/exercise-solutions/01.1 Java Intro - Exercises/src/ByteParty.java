import java.util.Scanner;

public class ByteParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());

            numbers[i] = num;
        }

        while (true){
            String[] input = scanner.nextLine().split(" ");

            if(input[0].equals("party")){
                for (int i = 0; i < n; i++) {
                    System.out.println(numbers[i]);
                }
                break;
            }

            int action = Integer.parseInt(input[0]);
            int position = Integer.parseInt(input[1]);

            switch (action){
                case -1:
                    int mask = 1<<position;

                    for (int i = 0; i < numbers.length ; i++) {
                        numbers[i] = numbers[i] ^ mask;
                    }
                    break;
                case 0:
                    int mask1 = ~(1 << position);

                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] & mask1;
                    }
                    break;
                case 1:
                    int mask2 = 1 << position;
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] | mask2;
                    }
                    break;
            }

        }
    }
}
