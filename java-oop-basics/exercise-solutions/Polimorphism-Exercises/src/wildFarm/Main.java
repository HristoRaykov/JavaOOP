package wildFarm;

import wildFarm.abstractions.Animal;
import wildFarm.factories.AnimalFactory;
import wildFarm.factories.FoodFactory;
import wildFarm.food.Food;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Animal> animals = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        fillAnimalsToList(reader);
        printAnimals();
    }

    private static void fillAnimalsToList(BufferedReader reader) throws IOException {
        while (true) {
            String[] animalInfo = reader.readLine().split(" ");
            if (animalInfo[0].equals("End")) {
                break;
            }
            String[] foodInfo = reader.readLine().split(" ");

            Food currentFood = new FoodFactory().getFoodType(foodInfo);
            AnimalFactory animalFactory = new AnimalFactory();
            Animal currentAnimal = null;

            switch (animalInfo[0]) {
                case "Tiger":
                    try {
                        currentAnimal = animalFactory.getAnimalType(animalInfo);
                        currentAnimal.makeSound();
                        currentAnimal.eat(currentFood);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "Mouse":
                    try {
                        currentAnimal = animalFactory.getAnimalType(animalInfo);
                        currentAnimal.makeSound();
                        currentAnimal.eat(currentFood);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "Zebra":
                    try {
                        currentAnimal = animalFactory.getAnimalType(animalInfo);
                        currentAnimal.makeSound();
                        currentAnimal.eat(currentFood);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "Cat":
                    currentAnimal = animalFactory.getAnimalType(animalInfo);
                    currentAnimal.makeSound();
                    currentAnimal.eat(currentFood);
                    break;
            }
            if (currentAnimal != null) {
                animals.add(currentAnimal);
            }
        }
    }

    private static void printAnimals() {
        for (Animal animal : animals) {
            System.out.print(animal);
        }
    }
}
