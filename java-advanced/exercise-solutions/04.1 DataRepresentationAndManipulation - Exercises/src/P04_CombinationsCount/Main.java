package P04_CombinationsCount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int combinations = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

       choose(n, k);
        System.out.println(combinations);

    }public static int choose(int n, int k){
        if (k == 0){
            return 1;
        }else if(n == k){
            return 1;
        }
        combinations++;
        return choose(n-1, k) + choose(n-1, k-1);
    }
}
