package animalgame;

import animalgame.animals.abstractmodels.Animal;
import animalgame.food.abstractmodels.Food;



/***
 * Store class, handling selling and buying of objects
 *
 * @author Ashraf, Sharshar
 */

public class Store {

    /***
     * Buys an amount of animals. Checks if players has enough money and such.
     *
     */
    public void buyAnimal(Player player, Animal animal, int amount){
        if(player.getPlayerBudget() >= animal.getCost()*amount) {
            int animalBudget = (int) Math.floor(player.getPlayerBudget() / animal.getCost());   //Checks how many animals of chosen type player can afford
            int purchasedAnimals = 0;
            if (animalBudget == 0) {                                                          // if 0
                System.out.println("Animal prices:  " + animal.getType());
            } else {
                for (int i = 0; i < amount; i++) {
                    player.setPlayerBudget(player.getPlayerBudget() - animal.getCost());// else calculate how much cash player has left after buying animals
                    player.getAnimal(animal);
                    purchasedAnimals++;
                }
                System.out.println("You bought " + purchasedAnimals + " of type: " + animal.getType());
            }
        } else {
            System.out.println("No money");
        }
    }
    /***
     * Buys  food. Check if player can afford it
     *
     */
    public void buyFood(Player player, Food food, int amount){
        if(player.getPlayerBudget() >= food.getCost()*amount) {
            int foodBudget = (int) Math.floor(player.getPlayerBudget() / food.getCost());        //Checks how many kgs of food of chosen type player can afford
            int purchasedfood = 0;
            if ((foodBudget == 0) || (amount > foodBudget)) {                                                             // if 0 or too great
                System.out.println("Not available " + food.getType());
            } else {
                player.setPlayerBudget(player.getPlayerBudget() - (food.getCost()) * amount);                    // else calculate how much cash player has left after buying food
                for (int spawnLoop = 0; spawnLoop < amount; spawnLoop++) {
                    player.addPlayerFood(food);
                    purchasedfood++;
                }
                System.out.println("You bought " + purchasedfood + " of type: " + food.getType());
            }
        } else {
            System.out.println("No money");
        }
    }

    /**
     * Sells animals
     *
     * @param player Player, player object corresponding to seller
     * @param sellAnimal Animal, animalobject to be sold
     */
    public void sellAnimal(Player player, Animal sellAnimal){
        player.removeAnimal(sellAnimal);
    }
}