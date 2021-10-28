package animalgame;

import animalgame.animals.Cat;
import animalgame.animals.Chicken;
import animalgame.animals.Cow;
import animalgame.animals.Dog;
import animalgame.animals.abstractmodels.Animal;
import animalgame.food.*;
import animalgame.food.abstractmodels.Food;

import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;


public class Player {
    private int playerCash;
    private final String playerName;
    public CopyOnWriteArrayList<Animal> playerAnimals = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<Animal> playerDeadAnimals = new CopyOnWriteArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    public Hay hay = new Hay();
    public Meat meat = new Meat();
    public Milk milk = new Milk();
    public Seed seed = new Seed();
    public Vegetables vegetables = new Vegetables();

    public Player(int startCash, String name){
        this.playerCash = startCash;
        this.playerName = name;
    }

    /***
     * Gets players current amount of money
     *
     * @return int, players cash
     */
    public int getPlayerCash() {
        return playerCash;
    }

    /***
     * Sets players cash
     *
     * @param playerCash int, player cash
     */
    public void setPlayerCash(int playerCash) {
        this.playerCash = playerCash;
    }

    /***
     * Gets players name
     *
     * @return String players name
     */
    public String getPlayerName() {
        return playerName;
    }


    public void addPlayerFood(Food food){
        switch (food.getType()) {
            case HAY -> this.hay.addAmountOwned();
            case MEAT -> this.meat.addAmountOwned();
            case MILK -> this.milk.addAmountOwned();
            case SEED -> this.seed.addAmountOwned();
            case VEGETABLES -> this.vegetables.addAmountOwned();
        }
    }


    public int getPlayerFood(Food food){
        int none = 0;
        return switch (food.getType()) {
            case HAY -> this.hay.getAmountOwned();
            case MEAT -> this.meat.getAmountOwned();
            case MILK -> this.milk.getAmountOwned();
            case SEED -> this.seed.getAmountOwned();
            case VEGETABLES -> this.vegetables.getAmountOwned();
            default -> none;
        };
    }

    /***
     * Removed a single food of type food
     * @param food Food, type of food
     */
    public void removePlayerFood(Food food){
        String foodType = String.valueOf(food.getType());
        switch (foodType) {
            case "HAY" -> this.hay.removeAmountOwned();
            case "MEAT" -> this.meat.removeAmountOwned();
            case "MILK" -> this.milk.removeAmountOwned();
            case "SEED" -> this.seed.removeAmountOwned();
            case "VEGETABLES" -> this.vegetables.removeAmountOwned();
            default -> throw new IllegalStateException("Unexpected value: " + food);
        }
    }

    /***
     * Creates animals that are bought from the store
     * Lets' player chose sex and name of animal bought in store
     *
     * @param animal Animal, type of animal to spawn
     */
    public void spawnAnimalfromStore(Animal animal){
        Animal blob = AnimalFactorySpawn(animal);

        System.out.println("Chose gender (M/F): ");
        String sex = scanner.next();
        if (sex.equalsIgnoreCase("M")) {
            blob.setSex(Animal.Sex.MALE);
        }
        else if (sex.equalsIgnoreCase("F")) {
            blob.setSex(Animal.Sex.FEMALE);
        } else {
            System.out.println("Couldn't hear you, you got a " + animal.getSex());
        }
        System.out.println("Name the animal: ");
        blob.setName(scanner.next());
        playerAnimals.add(blob);
    }

    /***
     * Creates animals that are made from breeding
     * Lets' player set name only, randomly assigns sex
     *
     * @param animal Animal, type of animal to spawn
     */
    public void spawnAnimalfromBreeding(Animal animal){
        Animal blob = AnimalFactorySpawn(animal);
        System.out.println("Congratulations, it's a " + blob.getSex() + " " + blob.getType());
        System.out.println("Name the animal: ");
        blob.setName(scanner.next());
        playerAnimals.add(blob);
    }

    /***
     * Prints players currently owned animals
     */
    public void countAnimals(){
        if(playerAnimals.size() != 0){
            for(Animal animal:playerAnimals) {
                System.out.println(animal.getName() + " the " + animal.getType() + " (" + animal.getSex() + "), " + animal.getHealth() + "% happy");
            } }else {
            System.out.println("No animals here ~");
        }
    }

    /***
     * Returns an ArrayList of players animals
     * @return CopyOnWriteArrayList<Animal> CopyOnWriteArrayList, contains players animals
     */
    public CopyOnWriteArrayList<Animal> getAnimalArray(){
        return playerAnimals;
    }

    /***
     * Sell animal. Give player money and remove animal from player
     *
     * @param removeAnimal Animal, specific animal object to sell
     */
    public void removeAnimal(Animal removeAnimal){
        float value = removeAnimal.getCost();
        float health = removeAnimal.getHealth();
        value = value*(health/100);

        System.out.println(this.playerName + " just sold " + removeAnimal.getName() + " the " + removeAnimal.getType() + " for $" + value);
        playerCash = playerCash + (int)value;
        playerAnimals.remove(removeAnimal);
    }

    /***
     * Sells all animals' player owns
     */
    public void sellAllAnimal(){
        for(Animal animal: playerAnimals){
            removeAnimal(animal);
        }
    }

    /***
     * Removes health from players owned animals at the end of the round,
     * sets animal health to 100 if more than 100.
     *
     * Adds dead animals to playerDeadAnimals ArrayList
     */
    public void roundEndHealthDecrease(){
        for(Animal loopanimal: playerAnimals){
            loopanimal.removeHealthAnimal();
            if(loopanimal.getHealth() > 100){
                loopanimal.setHealth(100);
            }
            if(loopanimal.getHealth() <= 0){
                playerDeadAnimals.add(loopanimal);
                playerAnimals.remove(loopanimal);
            }

        }
    }

    /***
     * Announces dead animals, removes from playerDeadAnimals ArrayList
     */
    public void deadAnimalControl(){
        System.out.println();
        for(Animal deadanimal: playerDeadAnimals){
            System.out.println(deadanimal.getName() + " the " + deadanimal.getType() + " has passed away.");
            playerDeadAnimals.remove(deadanimal);
        }
    }

    public Animal AnimalFactorySpawn(Animal animal){
        switch (animal.getType().toUpperCase()){

            case "CHICKEN":
                return new Chicken();
            case "COW":
                return new Cow();
            case "CAT":
                return new Cat();
            case "DOG":
                return new Dog();
            default:
                return null;
        }
    }

}
