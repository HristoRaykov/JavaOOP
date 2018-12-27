import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class p06_SortLines {
    public static void main(String[] args) {

        final String inputPath = "D:\\input.txt";
        final String outputPath = "D:\\output.txt";

        Path path = Paths.get(inputPath);
        Path path1 = Paths.get(inputPath);

        try {
            List<String> lines = Files.readAllLines(path);

            Collections.sort(lines);

            Files.write(path1, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
