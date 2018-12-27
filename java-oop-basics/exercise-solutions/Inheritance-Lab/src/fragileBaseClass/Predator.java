package fragileBaseClass;

public class Predator extends Animal {
    private int health;

    public void feed(Food food){
        health++;
        super.eat(food);
    }
}
