package P05_PizzaCalories.Pizza;

public class Pizza {
    private String name;
    private Dough dough;
    private Toppings toppings;

    public Pizza(String name, Dough dough, Toppings toppings) {
        setName(name);
        setDough(dough);
        setToppings(toppings);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() < 1 || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }else{
            this.name = name;
        }
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public Toppings getToppings() {
        return toppings;
    }

    public void setToppings(Toppings toppings) {
        this.toppings = toppings;
    }
    public double getCalories(double weight, Dough dough, Toppings toppings){
        return (2 * weight) * dough.getType() * toppings.getType();
    }
}
