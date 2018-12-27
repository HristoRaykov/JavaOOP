import java.io.*;
import java.util.Scanner;

public class p05_EveryThirdLine {
    public static void main(String[] args) {

        String inputPath = "D:\\input.txt";
        String outputPath = "D:\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)) {

            String line = reader.readLine();
            int counter = 1;

            while (line != null) {
                if (counter % 3 == 0) {
                   writer.println(line);
                }
                line = reader.readLine();
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
