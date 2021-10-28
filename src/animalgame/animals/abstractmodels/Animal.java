package animalgame.animals.abstractmodels;

import animalgame.animals.Cat;
import animalgame.animals.Chicken;
import animalgame.animals.Cow;
import animalgame.animals.Dog;

import java.util.Set;

/**The abstract class for all the animal type classes
 *
 * @author Ashraf and Sharshar
 */

public abstract class Animal {

    public enum Sex { //gender options for the animals
        MALE, FEMALE
    }

    public enum Diet { // Diet options for the animals
        HAY,MEAT,MILK,SEED,VEGETABLES
    }

    public Set<Diet> animalDiet; //Interface to set the diet for the animals


    private int foodMultiplier; // health increase by food

    private String name; // animal name
    private String type; // animal type

    private Sex sex; // animal gender

    private int health; //animal health

    private int cost; // animal cost

    public Animal() { // constructor which is taking the
        this.sex = (Math.random() < 0.5) ? Sex.MALE : Sex.FEMALE;
        this.health = 100;
    }
    public int getFoodMultiplier() { //getter for health increasing value
        return foodMultiplier;
    }


    public void removeHealthAnimal(){
        this.setHealth(this.getHealth() - (int) ((Math.random() * 20) + 10));
    }


    public void setFoodMultiplier(int foodMultiplier) {
        this.foodMultiplier = foodMultiplier;
    }


    public void setType(String type) {
        this.type = type;
    }


    public void setSex(Sex sex) {
        this.sex = sex;
    }


    public void setCost(int cost) {
        this.cost = cost;
    }


    public int getCost(){
        return cost;
    }

    public String getType() {
        return type;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if (this.health > 100){
            this.health = 100;
        }
    }


    public Set<Diet> getDiet(){
        return animalDiet;
    }


}