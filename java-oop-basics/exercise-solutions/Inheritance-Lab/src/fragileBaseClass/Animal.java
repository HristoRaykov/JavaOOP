package fragileBaseClass;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    protected List<Food> foodEaten = new ArrayList<>();

    public final void eat(Food food){
        this.foodEaten.add(food);
    }
    public final void eatAll(Food[] foods){
        for (Food food : foods) {
            eat(food);
        }
    }
}
