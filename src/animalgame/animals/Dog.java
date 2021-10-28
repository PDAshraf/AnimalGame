package animalgame.animals;

import animalgame.*;
import animalgame.animals.abstractmodels.Animal;
import animalgame.food.abstractmodels.Food;
import animalgame.food.Meat;
import animalgame.food.Milk;
import animalgame.food.Vegetables;

import java.util.EnumSet;

public class Dog extends Animal {

    public Dog() { //Constructor to set animal diet, cost, type, healthbooster
        animalDiet = EnumSet.of(Diet.MEAT, Diet.MILK);//fix what chicken can eat
        setCost(10); // set the price
        setType("Dog"); //set the type
        setFoodMultiplier(5); // set the healthbooster
    }
}