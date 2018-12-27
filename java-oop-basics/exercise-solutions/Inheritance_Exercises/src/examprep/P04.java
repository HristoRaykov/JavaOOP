package examprep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double n = Double.parseDouble(reader.readLine());
        double count = n;

        int poormark = 0;
        int SatisfactoryMark = 0;
        int Goodmark = 0;
        int Verygoodmark = 0;
        int ExcellentMark = 0;

        while (n-- > 0) {
            double grade = Double.parseDouble(reader.readLine());

            if (grade < 22.5) {
                poormark++;
            } else if (grade < 40.5) {
                SatisfactoryMark++;
            } else if (grade < 58.5) {
                Goodmark++;
            }else if(grade < 76.5){
                Verygoodmark++;
            }else if(grade < 100.0){
                ExcellentMark++;
            }
        }

        System.out.printf("%.2f%% poor marks%n", poormark * 100.0 / count);
        System.out.printf("%.2f%% satisfactory marks%n",  SatisfactoryMark * 100.0 / count);
        System.out.printf("%.2f%% good marks%n",  Goodmark * 100.0 / count);
        System.out.printf("%.2f%% very good marks%n", Verygoodmark * 100.0 / count);
        System.out.printf("%.2f%% excellent marks%n",  ExcellentMark * 100.0 / count);
    }
}
