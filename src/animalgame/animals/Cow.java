package animalgame.animals;

import animalgame.*;
import animalgame.animals.abstractmodels.Animal;
import animalgame.food.abstractmodels.Food;
import animalgame.food.Hay;
import animalgame.food.Meat;
import animalgame.food.Seed;

import java.util.EnumSet;

public class Cow extends Animal {

    public Cow() { //Constructor to set animal diet, cost, type, healthbooster
        animalDiet = EnumSet.of(Diet.HAY, Diet.VEGETABLES);//fix what chicken can eat
        setCost(10); // set the price
        setType("Cow"); //set the type
        setFoodMultiplier(5); // set the healthbooster
    }
}