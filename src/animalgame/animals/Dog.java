package animalgame.animals;

import animalgame.animals.abstractmodels.Animal;

import java.util.EnumSet;

public class Dog extends Animal {

    public Dog() {
        animalDiet = EnumSet.of(Diet.MEAT, Diet.MILK);//Spacified food
        setCost(60); //Price
        setType("Dog");
        setFoodBoost(60); //Healthboost after food
    }
}