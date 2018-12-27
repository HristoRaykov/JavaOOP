package examprep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double tomatos = Double.parseDouble(reader.readLine());
        int kasetki = Integer.parseInt(reader.readLine());
        int burkani = Integer.parseInt(reader.readLine());

        double kgLutenitsa = tomatos / 5;
        double burkaniNeeded = kgLutenitsa / 0.535;
        double kasetiNeeded = burkaniNeeded / burkani;

        System.out.printf("Total lutenica: %.0f kilograms.%n", Math.floor(kgLutenitsa));

        if(kasetiNeeded > kasetki){
            System.out.printf("%.0f boxes left.%n", Math.floor(kasetiNeeded - kasetki));
            System.out.printf("%.0f jars left.", Math.floor(burkaniNeeded - (kasetki * burkani)));
        }else{
            System.out.printf("%.0f more boxes needed.%n", Math.floor(kasetki - kasetiNeeded));
            System.out.printf("%.0f more jars needed.", Math.floor((kasetki * burkani) - burkaniNeeded));
        }
    }
}
