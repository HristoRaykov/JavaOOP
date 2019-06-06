package wildFarm.factories;

import wildFarm.abstractions.Animal;
import wildFarm.food.Food;
import wildFarm.implementators.Cat;
import wildFarm.implementators.Mouse;
import wildFarm.implementators.Tiger;
import wildFarm.implementators.Zebra;

public class AnimalFactory {

    public Animal getAnimalType(String[] animalInfo){
        String type = animalInfo[0];
        String name = animalInfo[1];
        double weight = Double.parseDouble(animalInfo[2]);
        String livingRegion = animalInfo[3];
        switch (type){
            case "Tiger":
              return new Tiger(name, type, weight, 0, livingRegion);
            case "Mouse":
               return new Mouse(name, type, weight,0, livingRegion);
            case "Zebra":
               return new Zebra(name, type, weight, 0, livingRegion);
            case "Cat":
                String breed = animalInfo[4];
               return new Cat(name, type, weight, 0, livingRegion, breed);
               default:return null;
        }
    }
}
