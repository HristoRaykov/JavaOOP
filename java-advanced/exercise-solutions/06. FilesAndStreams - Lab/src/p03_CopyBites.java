import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class p03_CopyBites {

    public static void main(String[] args) {
        String inputPath = "D:\\input.txt";
        String outputPath = "D:\\output.txt";

        try(FileInputStream fis = new FileInputStream(inputPath); FileOutputStream fos = new FileOutputStream(outputPath)) {

            int oneByte = fis.read();

            while(oneByte >= 0){

                String digits = String.valueOf(oneByte);

                if(oneByte == 32 || oneByte == 10){
                    fos.write(oneByte);
                }else {
                    for (int i = 0; i < digits.length(); i++) {

                        fos.write(digits.charAt(i));
                    }
                }
                oneByte = fis.read();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
