package wildFarm.implementators;

import wildFarm.abstractions.Felime;
import wildFarm.food.Food;

import java.text.DecimalFormat;

public class Tiger extends Felime {

    public Tiger(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if(food.getType().equals("Meat")){
            super.setFoodEaten(food.getQuantity());
        }else{
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
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
