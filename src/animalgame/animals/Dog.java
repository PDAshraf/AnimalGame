package animalgame.animals;

import animalgame.*;
import animalgame.animals.abstractmodels.Animal;
import animalgame.food.abstractmodels.Food;
import animalgame.food.Meat;
import animalgame.food.Milk;
import animalgame.food.Vegetables;

public class Dog extends Animal { // meat milk

    public Dog(String name, String gender) {
        super(name, gender);
        super.price=100;
        super.health=75;
    }

    public String getSpecies(){
        String species ="animalgame.animals.Dog";
        return species;
    }

    public void eat(Food food, Player player, int indexChosen, int amountFood) { //Cats eat meat/milk
        if (food instanceof Vegetables) {
            System.out.println("Not valid food");
        } else if ((food instanceof Meat) || (food instanceof Milk)) {
            System.out.println("**animalgame.animals.Dog Eating**");
            gainHealth(food,player,indexChosen,amountFood);
        }
    }

    public void gainHealth(Food food, Player player, int indexChosen, int amountOfFood) {
        int healthLv = player.animalList.get(indexChosen).health;
        if (food instanceof Meat) {
            player.animalList.get(indexChosen).health = healthLv + 10 * amountOfFood;
        } else {
            player.animalList.get(indexChosen).health= healthLv + 5 * amountOfFood;
        }
    }
}