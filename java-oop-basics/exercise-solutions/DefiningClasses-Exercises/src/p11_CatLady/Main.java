package p11_CatLady;

import p11_CatLady.cat.Cat;
import p11_CatLady.cat.Cymric;
import p11_CatLady.cat.Siamese;
import p11_CatLady.cat.StreetExtraordinaire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        Map<String, Cat> catMap = new HashMap<>();

        while(!"end".equalsIgnoreCase(line)){
            String[] commandArgs = line.split(" ");
            Cat cat = null;
            switch (commandArgs[0]){
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(commandArgs[0], commandArgs[1], Double.parseDouble(commandArgs[2]));
                    break;
                case "Siamese":
                    cat = new Siamese(commandArgs[0], commandArgs[1], Double.parseDouble(commandArgs[2]));
                    break;
                case "Cymric":
                    cat = new Cymric(commandArgs[0], commandArgs[1], Double.parseDouble(commandArgs[2]));
                    break;
            }
            catMap.put(commandArgs[1], cat);

            line = reader.readLine();
        }
        System.out.println(catMap.get(reader.readLine()));
    }
}
