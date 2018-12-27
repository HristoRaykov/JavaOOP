package examprep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P06 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        int firstTwo = i + j;
                        int secondTwo = k + l;
                        if((firstTwo == secondTwo) && (n % firstTwo == 0)){
                            System.out.printf("%s%s%s%s ", i, j, k, l);
                        }
                    }
                }
            }
        }
    }
}
