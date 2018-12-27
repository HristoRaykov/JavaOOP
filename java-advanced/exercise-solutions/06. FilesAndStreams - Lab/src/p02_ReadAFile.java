import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p02_ReadAFile {
    public static void main(String[] args) {

        String inputPath = "D:\\input.txt";
        String outputPath = "D:\\output.txt";

        List<Character> chars = new ArrayList<>();

        Collections.addAll(chars, '?', '.', '!', ',');

        try(FileInputStream fis = new FileInputStream(inputPath); FileOutputStream fos = new FileOutputStream(outputPath)) {

            int oneByte = fis.read();

            while(oneByte >= 0){

                if(!chars.contains((char)oneByte)){
                    fos.write(oneByte);
                }
                oneByte = fis.read();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
