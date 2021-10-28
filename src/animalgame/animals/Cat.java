package animalgame.animals;


import animalgame.animals.abstractmodels.Animal;



import java.util.EnumSet;

public class Cat extends Animal {
    public Cat() { //Constructor to set animal diet, cost, type, healthbooster
        animalDiet = EnumSet.of(Diet.MEAT, Diet.MILK);//fix what chicken can eat
        setCost(10); // set the price
        setType("Cat"); //set the type
        setFoodMultiplier(5); // set the healthbooster
    }
}