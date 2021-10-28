package animalgame.animals;

import animalgame.animals.abstractmodels.Animal;

import java.util.EnumSet;

public class Chicken extends Animal {

    public Chicken() {
        animalDiet = EnumSet.of(Diet.SEED, Diet.VEGETABLES);//Specified food
        setCost(10); //price
        setType("Chicken");
        setFoodBoost(10); //Healthboost after food
    }
}
