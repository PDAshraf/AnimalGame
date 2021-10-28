package animalgame.food.abstractmodels;


/**The abstract class for all food type classes
 *
 * @author Ashraf and Sharshar
 */

public abstract class Food {
    private Diet type; // Food type variable
    private int healthBoost; // health gained per serve
    private int cost; //food price variable
    public int amount = 0; // variable that check how many player owns

    /**
     * Method to get how much food animal own
     * Getter
     *
     * @return the amount of food
     */
    public int getAmountOwned() {
        return amount;
    }

    /**
     * Method to add the amount of food to player list
     * add the amount of food when buy food
     */
    public void addAmountOwned() {
        this.amount++;
    }

    /**
     * Method to decrease amount of food from the player list
     * decrease amount of food when feed
     */
    public void removeAmountOwned() {
        this.amount--;
    }

    public enum Diet { //Food options for the animals
        HAY, MEAT, MILK, SEED, VEGETABLES, NONE
    }

    /**
     * Method to set diet for the animals
     * set which animal can eat what
     *
     * @param diet diet for the animals
     */
    public void setDiet(Food.Diet diet) {
        this.type = diet;
    }

    /**
     * Method to get the price for the food
     * Getter
     *
     * @return cost for the food
     */
    public int getPrice() {
        return cost;
    }

    /**
     * Method to get diet type
     * Getter
     *
     * @return type of diet
     */
    public Diet getType() {
        return type;
    }

    /**
     * Method to get healthboost
     * Getter
     *
     * @return healthboost
     */
    public int getHealthBoost() {
        return healthBoost;
    }

    /**
     * Method to set food cost
     * Setter
     *
     * @param cost price for food
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Method to set healthboost
     * Setter
     *
     * @param healthBoost
     */
    public void setHealthBoost(int healthBoost) {
        this.healthBoost = healthBoost;
    }

    public int getCost(){
        return cost;
    }

}
