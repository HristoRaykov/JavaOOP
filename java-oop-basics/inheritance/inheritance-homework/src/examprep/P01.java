package examprep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int daljina = Integer.parseInt(reader.readLine());
        int shirochina = Integer.parseInt(reader.readLine());
        double visochina = Double.parseDouble(reader.readLine());
        double cenaNaMrejata = Double.parseDouble(reader.readLine());
        double tegloNaMrejata = Double.parseDouble(reader.readLine());

        double duljiNaMrejata = 2 * daljina + 2 * shirochina;
        double cena = duljiNaMrejata * cenaNaMrejata;
        double ploshtNaMrejata = duljiNaMrejata * visochina;
        double teglo = ploshtNaMrejata * tegloNaMrejata;

        System.out.printf("%.0f%n%.2f%n%.3f", duljiNaMrejata, cena, teglo);

    }
}
