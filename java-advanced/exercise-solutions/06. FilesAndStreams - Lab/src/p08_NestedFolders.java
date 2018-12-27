import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class p08_NestedFolders {
    public static void main(String[] args) {

        final String inputPath = "D:\\Files-and-Streams";

        File file = new File(inputPath);

        Deque<File> queue = new ArrayDeque<>();

        queue.offer(file);
        int count = 1;
        while (!queue.isEmpty()) {
            File currentFile = queue.poll();

            File[] nestedDirs = currentFile.listFiles();

            for (File dir : nestedDirs) {

                if (dir.isDirectory()) {
                    queue.offer(dir);
                    count++;
                }
            }
            System.out.println(currentFile.getName());
        }

        System.out.println(count + " folders");
    }
}
