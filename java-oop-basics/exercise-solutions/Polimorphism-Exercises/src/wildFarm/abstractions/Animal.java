package wildFarm.abstractions;

import wildFarm.food.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    public Animal(String animalName, String animalType, double animalWeight, int foodEaten) {
        this.setAnimalName(animalName);
        this.setAnimalType(animalType);
        this.setAnimalWeight(animalWeight);
        this.setFoodEaten(foodEaten);
    }

    private void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    private void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    private void setAnimalWeight(double animalWeight) {
        this.animalWeight = animalWeight;
    }

    protected void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    protected final String getAnimalName() {
        return animalName;
    }

    protected final String getAnimalType() {
        return animalType;
    }

    protected final double getAnimalWeight() {
        return animalWeight;
    }

    protected final int getFoodEaten() {
        return foodEaten;
    }

    public abstract void makeSound();
    public abstract void eat(Food food);

    @Override
    public abstract String toString();
}
