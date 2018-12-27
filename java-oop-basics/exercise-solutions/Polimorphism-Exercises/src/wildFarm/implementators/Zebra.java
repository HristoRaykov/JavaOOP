package wildFarm.implementators;

import wildFarm.abstractions.Mammal;
import wildFarm.food.Food;

import java.text.DecimalFormat;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if(food.getType().equals("Vegetable")){
            super.setFoodEaten(food.getQuantity());
        }else{
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getAnimalType())
                .append("[")
                .append(super.getAnimalName())
                .append(", ")
                .append(String.format("%s", new DecimalFormat("#.##").format(super.getAnimalWeight())))
                .append(", ")
                .append(super.getLivingRegion())
                .append(", ")
                .append(super.getFoodEaten())
                .append("]")
                .append(System.lineSeparator());

        return sb.toString();
    }
}
