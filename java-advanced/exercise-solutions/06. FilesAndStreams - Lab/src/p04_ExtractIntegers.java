import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class p04_ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = "D:\\input.txt";
        String outputPath = "D:\\output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)) {

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    writer.println(scanner.nextInt());
                }
                scanner.next();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
