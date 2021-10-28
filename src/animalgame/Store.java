package animalgame;

import animalgame.animals.*;
import animalgame.animals.abstractmodels.Animal;
import animalgame.food.*;
import animalgame.food.abstractmodels.Food;



/***
 * Store handles buying animals and food, selling animals
 *
 * @author Andreas Lindgren, Toriqul Islam Sohan
 */

public class Store {
    /***
     * Buys an amount of animals. Checks if players has enough money and such.
     *
     *
     * @param player Player, player object that is shopping
     * @param animal Animal, animal object corresponding to wanted animal
     * @param amount int, the number of animals to purchase
     */
    public void buyAnimal(Player player, Animal animal, int amount){
        if(player.getPlayerCash() >= animal.getCost()*amount) {
            int animalBudget = (int) Math.floor(player.getPlayerCash() / animal.getCost());   //Checks how many animals of chosen type player can afford
            int purchasedAnimals = 0;
            if (animalBudget == 0) {                                                          // if 0
                System.out.println("You couldn't even afford one " + animal.getType());
            } else {
                for (int spawnLoop = 0; spawnLoop < amount; spawnLoop++) {
                    player.setPlayerCash(player.getPlayerCash() - animal.getCost());// else calculate how much cash player has left after buying animals
                    player.spawnAnimalfromStore(animal);
                    purchasedAnimals++;
                }
                System.out.println("You bought " + purchasedAnimals + " of animal type: " + animal.getType());
            }
        } else {
            System.out.println("No credit dude.");
        }

    }
    /***
     * Buys an amount of food. Checks if players has enough money and such.
     *
     *
     * @param player Player, player object that is shopping
     * @param food Food, food object corresponding to wanted animal
     * @param amount int, the number of food to purchase
     */
    public void buyFood(Player player, Food food, int amount){
        if(player.getPlayerCash() >= food.getCost()*amount) {
            int foodBudget = (int) Math.floor(player.getPlayerCash() / food.getCost());        //Checks how many kgs of food of chosen type player can afford
            int purchasedfood = 0;
            if ((foodBudget == 0) || (amount > foodBudget)) {                                                             // if 0 or too great
                System.out.println("Dream on buddy! " + food.getType());
            } else {
                player.setPlayerCash(player.getPlayerCash() - (food.getCost()) * amount);                    // else calculate how much cash player has left after buying food
                for (int spawnLoop = 0; spawnLoop < amount; spawnLoop++) {
                    player.addPlayerFood(food);
                    purchasedfood++;
                }
                System.out.println("You bought " + purchasedfood + " kg of food type: " + food.getType());
            }
        } else {
            System.out.println("No credit dude.");
        }
    }

    /***
     * Sells animals
     *
     * @param player Player, player object corresponding to seller
     * @param sellAnimal Animal, animalobject to be sold
     */
    public void sellAnimal(Player player, Animal sellAnimal){
        player.removeAnimal(sellAnimal);
    }
}