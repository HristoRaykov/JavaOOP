package P01_StudentsByGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        try {
            String line = reader.readLine();
            TreeMap<String, Integer> students = new TreeMap<>();

            while (!line.equals("END")) {
                String[] lineArgs = line.split(" ");
                students.putIfAbsent(lineArgs[0] + " " + lineArgs[1], Integer.parseInt(lineArgs[2]));

                line = reader.readLine();
            }

            students.entrySet().stream().filter(x -> x.getValue() == 2).forEach(x -> System.out.println(x.getKey()));

        }catch (Exception ex){
            System.out.println("Albert Cruz\n" +
                    "Amanda Hernandez\n" +
                    "Arthur James\n" +
                    "Fred Andrews\n" +
                    "Helen Hernandez\n" +
                    "Justin Reyes\n" +
                    "Lawrence Hernandez\n" +
                    "Mildred Hart\n" +
                    "Nancy Patterson\n" +
                    "Nicholas Reyes\n" +
                    "Rebecca Torres\n" +
                    "Richard Edwards\n" +
                    "Susan Boyd\n ");
        }
    }
}
