package animalgame;

import animalgame.animals.Cat;
import animalgame.animals.Chicken;
import animalgame.animals.Cow;
import animalgame.animals.Dog;
import animalgame.animals.abstractmodels.Animal;
import animalgame.food.*;
import animalgame.food.abstractmodels.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.Integer.parseInt;

/***
 * Menu holds most user interaction
 *
 * @author Andreas Lindgren, Toriqul Islam Sohan
 */

public class Menu {
    int choice;
    Scanner scanner;
    Store store = new Store();
    Chicken chicken = new Chicken();  //Generic reference animals
    Cow cow = new Cow();
    Cat cat = new Cat();
    Dog dog = new Dog();
    Hay hay = new Hay();
    Meat meat = new Meat();
    Milk milk = new Milk();
    Seed seed = new Seed();
    Vegetables vegetables = new Vegetables();
    None none = new None();


    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    /***
     * SetupTurnMenu shows menu to chose turns
     *
     * @return int, number of rounds, or calls itself recursively
     */
    public int SetupTurnMenu() {
        System.out.println("How many rounds do you want to play\nChoose between (5-30)");
        System.out.print("Enter a number -> ");
        String input = scanner.next();
        try {
            int intInputValue = parseInt(input);
            if (intInputValue >= 5 && intInputValue <= 30) {
                System.out.println("you chose :" + intInputValue);
                return intInputValue;
            } else {
                System.out.println("wrong input!! choose between 5-30 only");
            }
        } catch (NumberFormatException ne) {
            System.out.println("This is not a number");
        }
        return SetupTurnMenu();
    }

    /***
     * SetupCashMenu
     *
     * @return int, amount of cash, or calls itself recursively
     */
    public int SetupCashMenu() {
        System.out.println("How much cash should players start with?");
        System.out.print("Enter a number -> ");
        String input = scanner.next();
        try {
            choice = parseInt(input);
            return choice;

        } catch (NumberFormatException ne) {
            System.out.println("This is not a number");
        }
        return SetupCashMenu();
    }
    /***
     * SetupPlayerMenu
     *
     * @return int, number of players, or calls itself recursively
     */
    public int SetupPlayerMenu() {
        System.out.println("How many players are playing?\nChoose between (1-4)");
        System.out.print("Enter a number -> ");
        String input2 = scanner.next();
        int intInputValue2;
        try {
            intInputValue2 = parseInt(input2);
            if (intInputValue2 >= 1 && intInputValue2 <= 4) {
                choice = intInputValue2;
                System.out.println("you chose: " + choice);
                return choice;
            } else {
                System.out.println("invalid input");

            }

        } catch (NumberFormatException ne) {
            System.out.println("This is not a number");
        }
        return SetupPlayerMenu();
    }

    /***
     * Sets name of player with index playerNumber
     *
     * @param playerNumber player index in ArrayList
     * @return consol input
     */
    public String SetupPlayerName(int playerNumber) {
        System.out.println("Enter name of player " + (1 + playerNumber) + ": ");
        return scanner.next();
    }

    /***
     * Prints current turn, current player, inventory, etc.
     *
     * @param player current player object
     * @param gameCurrentTurn current game turn
     */
    public void PrintPlayerStatus(Player player, int gameCurrentTurn) {
        System.out.println("\nCURRENT TURN: " + gameCurrentTurn);
        System.out.println("CURRENT PLAYER: " + player.getPlayerName() + "\n");

        System.out.println(player.getPlayerName() +
                " - Current $: " + player.getPlayerCash() +
                " - Available food: - hay, " +
                player.getPlayerFood(hay) + " kgs - Meat, " +
                player.getPlayerFood(meat) + " liters - Milk, " +
                player.getPlayerFood(milk) + " kgs - Seed, " +
                player.getPlayerFood(seed) + " kgs - Milk " +
                player.getPlayerFood(vegetables) + " kgs\n");
        System.out.println(player.getPlayerName() + " owns the following animals:");
        player.countAnimals();


    }

    /***
     * Shows main game menu
     *
     * @param player current player object
     */
    public void GameplayMenu(Player player) {
        System.out.println("""
                Let the game begin:: Choose from below
                1.Buy Animal
                2.Buy Food
                3.Feed Animal
                4.Pair Animal
                5.Sell Animal""");

        System.out.print("Enter a number -> ");
        String input = scanner.next();
        int intInputValue;
        try {
            intInputValue = parseInt(input);
            switch (intInputValue) {
                case 1 -> animalStoreBuy(player);
                case 2 -> foodStoreBuy(player);
                case 3 -> feedAnimal(player);
                case 4 -> breedAnimal(player);
                case 5 -> animalStoreSell(player);
                default -> System.out.println("Neit, ostorozhnyy!");
            }
        } catch (NumberFormatException ne) {
            System.out.println("This is not a number");
        }
    }

    /***
     * Shows store menu for animals
     *
     * @param player current player object
     */
    public void animalStoreBuy(Player player) {
        System.out.println("Buys an amount of chosen animals.\n");
        System.out.println("(1) " + chicken.getType() + " ~ $" + chicken.getCost() + " each. Diet: " + chicken.getDiet());
        System.out.println("(2) " + cat.getType() + " ~ $" + cat.getCost() + " each. Diet: " + cat.getDiet());
        System.out.println("(3) " + dog.getType() + " ~ $" + dog.getCost() + " each. Diet: " + dog.getDiet());
        System.out.println("(4) " + cow.getType() + " ~ $" + cow.getCost() + " each. Diet: " + cow.getDiet());
        System.out.print("Enter your number -> ");
        String input = scanner.next();
        System.out.println("How many do you want to buy?");
        String amount = scanner.next();
        try {
            switch (parseInt(input)) {
                case 1 -> store.buyAnimal(player, chicken, parseInt(amount));
                case 2 -> store.buyAnimal(player, cat, parseInt(amount));
                case 3 -> store.buyAnimal(player, dog, parseInt(amount));
                case 4 -> store.buyAnimal(player, cow, parseInt(amount));
                default -> {
                    System.out.println("This is not a choice, what the hell man.\n");
                    animalStoreBuy(player);
                }
            }
        } catch (NumberFormatException ne) {
            System.out.println("This is not a number");
        }
    }

    /***
     * Shows store menu for food
     *
     * @param player current player object
     */
    private void foodStoreBuy(Player player) {
        System.out.println("Buys an amount of chosen food.\n");
        System.out.println("(1) " + hay.getType() + " ~ $" + hay.getCost() + " per kg. Health boost: " + hay.getHealthBoost());
        System.out.println("(2) " + meat.getType() + " ~ $" + meat.getCost() + " per kg. Health boost: " + meat.getHealthBoost());
        System.out.println("(3) " + milk.getType() + " ~ $" + milk.getCost() + " per kg. Health boost: " + milk.getHealthBoost());
        System.out.println("(4) " + seed.getType() + " ~ $" + seed.getCost() + " per kg. Health boost: " + seed.getHealthBoost());
        System.out.println("(4) " + vegetables.getType() + " ~ $" + vegetables.getCost() + " per kg. Health boost: " + vegetables.getHealthBoost());
        String input = scanner.next();
        System.out.println("How many kgs do you want to buy?");
        String amount = scanner.next();
        switch (parseInt(input)) {
            case 1 -> store.buyFood(player, hay, parseInt(amount));
            case 2 -> store.buyFood(player, meat, parseInt(amount));
            case 3 -> store.buyFood(player, milk, parseInt(amount));
            case 4 -> store.buyFood(player, seed, parseInt(amount));
            case 5 -> store.buyFood(player, vegetables, parseInt(amount));
            default -> {
                System.out.println("There's only three kinds of food\n");
                foodStoreBuy(player);
            }
        }
    }

    /***
     * Shows menu for feeding animals
     *
     * @param player current player object
     */
    private void feedAnimal(Player player) {
        Food foodInPile = null;
        Animal feedingAnimal = null;
        int foodPile;

        System.out.println("Which animals do you want to feed?.\n");
        System.out.println("(1) " + chicken.getType() + " ~ Diet: " + chicken.getDiet());
        System.out.println("(2) " + cat.getType() + " ~ Diet: " + cat.getDiet());
        System.out.println("(3) " + dog.getType() + " ~ Diet: " + dog.getDiet());
        System.out.println("(4) " + cow.getType() + " ~ Diet: " + cow.getDiet());
        System.out.print("Enter animal: ");
        String fedAnimal = scanner.next();
        System.out.println("(1) " + hay.getType() + " ~ Health boost: " + hay.getHealthBoost());
        System.out.println("(2) " + meat.getType() + " ~ Health boost: " + meat.getHealthBoost());
        System.out.println("(3) " + milk.getType() + " ~ Health boost: " + milk.getHealthBoost());
        System.out.println("(4) " + seed.getType() + " ~ Health boost: " + seed.getHealthBoost());
        System.out.println("(5) " + vegetables.getType() + " ~ Health boost: " + vegetables.getHealthBoost());
        System.out.println("Enter food type: ");
        String chosenFood = scanner.next();
        System.out.println("Enter kgs of food: ");
        String foodAmount = scanner.next();

        try {
            switch (parseInt(chosenFood)) {
                case 1 -> foodInPile = hay;
                case 2 -> foodInPile = meat;
                case 3 -> foodInPile = milk;
                case 4 -> foodInPile = seed;
                case 5 -> foodInPile = vegetables;
                default -> foodInPile = none;

            }

            switch (parseInt(fedAnimal)) {
                case 1 -> feedingAnimal = chicken;
                case 2 -> feedingAnimal = cat;
                case 3 -> feedingAnimal = dog;
                case 4 -> feedingAnimal = cow;
                default -> System.out.println("Not valid!\n");
            }

        } catch (NumberFormatException ne) {
            System.out.println("This is not even a number\n");
        }

        foodPile = parseInt(foodAmount);

        if (foodPile > player.getPlayerFood(foodInPile)) {
            System.out.println("Can't feed animals with food you don't have.");
            feedAnimal(player);
        } else {
            CopyOnWriteArrayList<Animal> playersAnimals = player.getAnimalArray();
            while (foodPile > 0) {
                for (Animal individual : playersAnimals) {
                    assert feedingAnimal != null;
                    if (individual.getType().equals(feedingAnimal.getType())) {
                        String pickyEater = String.valueOf(individual.getDiet());

                        String currentServed = String.valueOf(foodInPile.getType());
                        if (pickyEater.contains(currentServed)) {
                            if (individual.getHealth() > 100) {
                                individual.setHealth(100);
                            } else {
                                int healingfromfood = foodInPile.getHealthBoost() * individual.getFoodMultiplier();
                                int individualhealth = individual.getHealth();
                                individual.setHealth((individualhealth + healingfromfood));
                                player.removePlayerFood(foodInPile);
                                foodPile = foodPile - 1;
                                System.out.println(individual.getName() + " the " + individual.getType() +
                                        " ate 1 kg of " +  foodInPile.getType().toString().toLowerCase() +
                                        ", new health is " +  individual.getHealth());
                            }
                        } else {
                            System.out.println("Invalid choice, go directly to jail...");
                            foodPile = 0;
                            feedAnimal(player);
                        }

                    }
                }
            }
        }
    }

    /***
     * Shows menu for breeding animals
     *
     * @param player current player object
     */
    private void breedAnimal(Player player) {
        int males = 0;
        int females = 0;
        int pairs = 0;
        Animal breedingAnimal = null;

        System.out.println("Which animals do you want to breed?.\n");
        System.out.println("(1) " + chicken.getType());
        System.out.println("(2) " + cat.getType());
        System.out.println("(3) " + dog.getType());
        System.out.println("(4) " + cow.getType());
        System.out.print("Enter animal: ");

        switch (parseInt(scanner.next())) {
            case 1 -> breedingAnimal = chicken;
            case 2 -> breedingAnimal = cat;
            case 3 -> breedingAnimal = dog;
            case 4 -> breedingAnimal = cow;
            default -> System.out.println("Not valid\n");
        }

        ArrayList<Animal> singletype = new ArrayList<>();
        for (Animal individual : player.getAnimalArray()) {

            if (individual.getType().equals(breedingAnimal.getType())) {
                singletype.add(individual);
            }
        }
        for (Animal individual : singletype) {

            if (individual.getSex().equals(Animal.Sex.MALE)) {
                males++;
            } else {
                females++;
            }
        }
        while (males > 0 && females > 0) {
            males--;
            females--;
            pairs++;
        }

        for (int breedLoop = pairs; breedLoop > 0; breedLoop--) {
            if ((Math.random() < 0.5)) {
                player.spawnAnimalfromBreeding(breedingAnimal);
            } else {
                System.out.println("Failed attempt");
            }
        }

    }

    /***
     * Shows menu for selling animals
     *
     * @param player current player object
     */
    public void animalStoreSell(Player player) {
        player.countAnimals();
        CopyOnWriteArrayList<Animal> playerInventory = player.getAnimalArray();
        String sold;

        System.out.println("Which animals do you want to sell?.\n");
        System.out.print("Enter animals (e.g. 1, 6, 15, 70...) : ");
        sold = scanner.next();
        List<String> currentlySelling = List.of(sold.split(","));
        ArrayList<Animal> markedSold = new ArrayList<>();

        for (String animalID : currentlySelling) {
            try {
                markedSold.add(playerInventory.get(Integer.parseInt(animalID)-1));

            } catch (IndexOutOfBoundsException e){
                System.out.println(animalID + " can't be sold");
            }
        }
        for (Animal animalID : markedSold) {
            store.sellAnimal(player, playerInventory.get(markedSold.indexOf(animalID)));
        }
    }

}
