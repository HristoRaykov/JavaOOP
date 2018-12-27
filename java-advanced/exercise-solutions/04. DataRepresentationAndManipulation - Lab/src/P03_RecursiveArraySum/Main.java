package P03_RecursiveArraySum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(sum(arr, 0));


    }public static int sum(int[] arr, int index){
        if(index == arr.length - 1){
            return arr[index];
        }
        return arr[index] + sum(arr, index + 1);
    }
}
