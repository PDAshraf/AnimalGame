package animalgame.animals;

import animalgame.animals.abstractmodels.Animal;

import java.util.EnumSet;

public class Cow extends Animal {

    public Cow() {
        animalDiet = EnumSet.of(Diet.HAY, Diet.VEGETABLES);//Specified food
        setCost(100); //Price
        setType("Cow");
        setFoodBoost(100); // set the healthbooster
    }
}