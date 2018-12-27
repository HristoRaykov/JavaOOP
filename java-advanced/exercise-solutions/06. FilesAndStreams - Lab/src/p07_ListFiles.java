import java.io.File;

public class p07_ListFiles {
    public static void main(String[] args) {

        final String inputPath = "D:\\Files-and-Streams";

        File file = new File(inputPath);

        if(file.isDirectory()){
           File[] files = file.listFiles();

            for (File file1 : files) {
                if(!file1.isDirectory()){
                    System.out.printf("%s: %s\n", file1.getName(), file1.length());
                }
            }
        }
    }
}
