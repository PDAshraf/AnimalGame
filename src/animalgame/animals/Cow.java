package animalgame.animals;

import animalgame.*;
import animalgame.animals.abstractmodels.Animal;
import animalgame.food.abstractmodels.Food;
import animalgame.food.Hay;
import animalgame.food.Meat;
import animalgame.food.Seed;

public class Cow extends Animal { // meat milk

    public Cow(String name, String gender) {
        super(name, gender);
        super.price=200;
        super.health=100;
    }

    public String getSpecies(){
        String species ="animalgame.animals.Cow";
        return species;
    }

    public void eat(Food food, Player player, int indexChosen, int amountFood) { //Cats eat meat/milk
        if (food instanceof Meat) {
            System.out.println("Not valid food");
        } else if ((food instanceof Hay) || (food instanceof Seed)) {
            System.out.println("**animalgame.animals.Cow Eating**");
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