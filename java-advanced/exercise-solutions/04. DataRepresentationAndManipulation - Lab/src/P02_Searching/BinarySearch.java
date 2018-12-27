package P02_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int num = Integer.parseInt(scanner.nextLine());

        System.out.println(binarySearch(numbers, num, 0, numbers.length));

    }
    public static int binarySearch (int[] numbers, int num, int start, int end){
        if(num > numbers[numbers.length-1]){
            return -1;
        }
       while (end >= start){
            int mid = (start + end) / 2;

            if(numbers[mid] > num ){
                end = mid - 1;
            }else if(numbers[mid] < num ){
                start = mid + 1;
            }else{
                return mid;
            }
       }
       return -1;
    }
}
