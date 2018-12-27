package P02_NestedLoopsToRecursion;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int numberOfLoops;
    public static int[] loops;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        numberOfLoops = Integer.parseInt(reader.readLine());
        loops = new int[numberOfLoops];
        simulateLoops(0);

    }public static void simulateLoops(int current){
        if(current == numberOfLoops){
            print();
            return;
        }
        for (int i = 1; i <= numberOfLoops; i++) {
            loops[current] = i;
            simulateLoops(current + 1);
        }
    }

    private static void print() {
        System.out.println(Arrays.toString(loops).replaceAll("[]\\[,]", ""));
    }
}
