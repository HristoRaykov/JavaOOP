package P05_PizzaCalories.Pizza;

public class Toppings {
    private static final int DEFAULT_CALORIES_PER_GRAM = 2;

    private double type;
    private double weight;

    public Toppings(String type, int weight) {
        setType(type);
      setWeight(weight);
    }

    public double getType() {
        return type;
    }

    public void setType(String type) {
        if(!type.equals("Meat") || !type.equals("Veggies") || !type.equals("Cheese") || !type.equals("Sauce")){
            throw new IllegalArgumentException("Cannot place " + type + " on top of your pizza.");
        }else{
            if(type.equals("Meat")){
                this.type = 1.2;
            }else if(type.equals("Veggies")){
                this.type = 0.8;
            }else if(type.equals("Cheese")){
                this.type = 1.1;
            }else if(type.equals("Sauce")){
                this.type = 0.9;
            }
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if(weight < 1 || weight > 50){
            throw new IllegalArgumentException(this.getType() + " weight should be in the range [1..50].");
        }else{
            this.weight = weight;
        }
    }
}
