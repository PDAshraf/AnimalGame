package animalgame.food.abstractmodels;


/**The abstract class for all food type classes
 *
 * @author Ashraf, Sharshar
 */

public abstract class Food {
    private Diet type; // Food type
    private int healthBoost; // health gain
    private int cost; //food price
    public int amount = 0;


    public int getAmountOwned() {
        return amount;
    }


    public void addAmountOwned() {
        this.amount++;
    }


    public void removeAmountOwned() {
        this.amount--;
    }

    public enum Diet { //Food options for the animals
        HAY, MEAT, MILK, SEED, VEGETABLES, NULL
    }


    public void setDiet(Food.Diet diet) {
        this.type = diet;
    }


    public int getPrice() {
        return cost;
    }


    public Diet getType() {
        return type;
    }


    public int getHealthBoost() {
        return healthBoost;
    }


    public void setCost(int cost) {
        this.cost = cost;
    }


    public void setHealthBoost(int healthBoost) {
        this.healthBoost = healthBoost;
    }

    public int getCost(){
        return cost;
    }

}
