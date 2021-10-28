package animalgame.animals;

import animalgame.animals.abstractmodels.Animal;
import animalgame.food.abstractmodels.Food;

import java.util.EnumSet;

public class Chicken extends Animal {

    public Chicken() { //Constructor to set animal diet, cost, type, healthbooster
        animalDiet = EnumSet.of(Diet.SEED, Diet.VEGETABLES);//fix what chicken can eat
        setCost(10); // set the price
        setType("Chicken"); //set the type
        setFoodMultiplier(5); // set the healthbooster
    }
}
