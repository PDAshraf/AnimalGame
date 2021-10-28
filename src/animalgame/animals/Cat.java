package animalgame.animals;


import animalgame.animals.abstractmodels.Animal;



import java.util.EnumSet;

public class Cat extends Animal {
    public Cat() {
        animalDiet = EnumSet.of(Diet.MEAT, Diet.MILK);//Specified Food
        setCost(50); // Cost
        setType("Cat");
        setFoodBoost(20); // Health boost
    }
}