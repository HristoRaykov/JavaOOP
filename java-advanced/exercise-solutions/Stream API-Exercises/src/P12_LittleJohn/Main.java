package P12_LittleJohn;

import javax.sound.midi.MetaEventListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern bigArrow = Pattern.compile("(>>>----->>|>>----->|>----->)");
//        Pattern mediumArrow = Pattern.compile(">>----->");
//        Pattern smallArrow = Pattern.compile(">----->");

        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            input.append(reader.readLine()).append("\r\n");
        }

        int bigCount = 0;
        int mediumCount = 0;
        int smallCount = 0;

        Matcher bigArrowMatcher = bigArrow.matcher(input);
        while (bigArrowMatcher.find()) {
            if(bigArrowMatcher.group(1).length() == 10){
                bigCount++;
            }else if(bigArrowMatcher.group(1).length() == 8){
                mediumCount++;
            }else{
                smallCount++;
            }
        }


        int concateCounts = Integer.parseInt(smallCount + "" + mediumCount + "" + bigCount + "");

        String binaryConcatenatedCount = Integer.toBinaryString(concateCounts);

        String binaryResult = binaryConcatenatedCount;

        for (int i = binaryConcatenatedCount.length() - 1; i >=0 ; i--) {
            binaryResult+= binaryConcatenatedCount.charAt(i);
        }

        int result = Integer.parseInt(binaryResult, 2);

        System.out.println(result);
    }
}
