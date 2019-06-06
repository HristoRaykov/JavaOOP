package P05_PizzaCalories.Pizza;

public class Dough {
    private static final int DEFAULT_CALORIES_PER_GRAM = 2;

    private double type;
    private int additionalType;
    private int weight;

    public Dough(String type, int additionalType, int weight) {
      setType(type);
      setAdditionalType(additionalType);
      setWeigth(weight);
    }

    public double getType() {
        return type;
    }

    public void setType(String type) {
        if(!type.equals("White") || !type.equals("Wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        if(type.equals("White")){
            this.type = 1.5;
        }else if(type.equals("Wholegrain")){
            this.type = 1;
        }
    }

    public int getAdditionalType() {
        return additionalType;
    }

    public void setAdditionalType(int additionalType) {
        this.additionalType = additionalType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeigth(int weigth) {
        if(weigth < 1 || weigth > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }else{
            this.weight = weigth;
        }
    }
}
