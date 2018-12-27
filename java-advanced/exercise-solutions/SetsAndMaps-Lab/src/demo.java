import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class demo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Double> stats = new TreeMap<>();

        int n = Integer.parseInt(reader.readLine());

        while(n-- > 0){
            String name = reader.readLine();
            double[] grades = Arrays.stream(reader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

            stats.put(name, Arrays.stream(grades).average().getAsDouble());
        }

        for (String s : stats.keySet()) {
            System.out.printf("%s is graduated with %f\n", s, stats.get(s));
        }
    }
}
