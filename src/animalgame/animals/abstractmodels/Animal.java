package animalgame.animals.abstractmodels;

import java.util.Set;

/**The abstract class for all the animal type classes
 *
 * @author Ashraf and Sharshar
 */

public abstract class Animal {

    public enum Gender { //gender method for animals
        MALE, FEMALE
    }

    public enum Diet { // Food choices
        HAY,MEAT,MILK,SEED,VEGETABLES
    }

    public Set<Diet> animalDiet; //Set food to animals


    private int foodBoost; // Increase health after food

    private String name; // animal name
    private String type; // animal type

    private Gender gender; // animal gender

    private int health; //animal health

    private int cost; // animal cost

    public Animal() { // constructor which is taking the
        this.gender = (Math.random() < 0.5) ? Gender.MALE : Gender.FEMALE;
        this.health = 100;
    }
    public int getFoodBoost() { //getter for health increasing value
        return foodBoost;
    }


    public void removeHealthAnimal(){
        this.setHealth(this.getHealth() - (int) ((Math.random() * 20) + 10));
    }


    public void setFoodBoost(int foodBoost) {
        this.foodBoost = foodBoost;
    }


    public void setType(String type) {
        this.type = type;
    }


    public void setGender(Gender gender) {
        this.gender = gender;
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

    public Gender getGender() {
        return gender;
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