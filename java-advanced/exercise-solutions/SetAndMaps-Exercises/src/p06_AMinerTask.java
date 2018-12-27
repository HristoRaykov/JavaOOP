import java.util.HashMap;
import java.util.Scanner;

public class p06_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Long> resources = new HashMap<>();

        while(true){

            String firstLine = scanner.nextLine();
            if(firstLine.equals("stop")){
                break;
            }
            String secondLine = scanner.nextLine();

            if(!resources.containsKey(firstLine)){
                resources.put(firstLine, Long.parseLong(secondLine));
            }else{
                resources.put(firstLine, resources.get(firstLine)  + Long.parseLong(secondLine));
            }
        }

        for (String s : resources.keySet()) {
            System.out.printf("%s -> %d\n", s, resources.get(s));
        }
    }
}
