package Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        while (!"beast!".equalsIgnoreCase(line)) {
            String[] animalInfo = reader.readLine().split(" ");

            try {
                switch (line) {
                    case "Dog":
                        Animal dog = new Dog(animalInfo[0], Integer.parseInt(animalInfo[1]), animalInfo[2]);
                        System.out.println(line);
                        System.out.println(dog);
                        break;
                    case "Cat":
                        Animal cat = new Cat(animalInfo[0], Integer.parseInt(animalInfo[1]), animalInfo[2]);
                        System.out.println(line);
                        System.out.println(cat);
                        break;
                    case "Frog":
                        Animal frog = new Frog(animalInfo[0], Integer.parseInt(animalInfo[1]), animalInfo[2]);
                        System.out.println(line);
                        System.out.println(frog);
                        break;
                    case "Tomcat":
                        Animal tomcat = new Tomcat(animalInfo[0], Integer.parseInt(animalInfo[1]), animalInfo[2]);
                        System.out.println(line);
                        System.out.println(tomcat);
                        break;
                    case "Kitten":
                        Animal kitten = new Kitten(animalInfo[0], Integer.parseInt(animalInfo[1]), animalInfo[2]);
                        System.out.println(line);
                        System.out.println(kitten);
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            line = reader.readLine();
        }
    }
}
