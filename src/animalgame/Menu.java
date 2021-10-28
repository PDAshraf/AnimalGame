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
 * Menu for most "game mechanics"
 *
 * @author Ashraf, Sharshar
 */

public class Menu {
    int choice;
    Scanner scanner;
    Store store = new Store();
    Chicken chicken = new Chicken();
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


    public int initGame() {
        System.out.println("How many rounds do you want to play\nChoose between (5-30)");
        System.out.print("Enter a number -> ");
        String input = scanner.next();
        try {
            int intInputValue = parseInt(input);
            if (intInputValue >= 5 && intInputValue <= 30) {
                System.out.println("you chose :" + intInputValue);
                return intInputValue;
            } else {
                System.out.println("Wrong input. Choose between 5-30 rounds");
            }
        } catch (NumberFormatException ne) {
            System.out.println("This is not a number");
        }
        return initGame();
    }


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

    public String setPlayerName(int playerNumber) {
        System.out.println("Enter name of player " + (1 + playerNumber) + ": ");
        return scanner.next();
    }


    public void getPlayerStatus(Player player, int gameCurrentTurn) {
        System.out.println("\nCURRENT TURN: " + gameCurrentTurn);
        System.out.println("CURRENT PLAYER: " + player.getPlayerName() + "\n");
        System.out.println(player.getPlayerName() +
                " - Current $: " + player.getPlayerBudget() +
                " - Available food: - hay, " +
                player.getPlayerFood(hay) + " kgs - Meat, " +
                player.getPlayerFood(meat) + " liters - Milk, " +
                player.getPlayerFood(milk) + " kgs - Seed, " +
                player.getPlayerFood(seed) + " kgs - Milk " +
                player.getPlayerFood(vegetables) + " kgs\n");
        System.out.println(player.getPlayerName() + " owns the following animals:");
        player.countAnimals();
    }

    public void gameMenu(Player player) {
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
                case 4 -> mateAnimal(player);
                case 5 -> animalStoreSell(player);
                default -> System.out.println("Not valid");
            }
        } catch (NumberFormatException ne) {
            System.out.println("Not a number. Enter a number");
        }
    }

    public void animalStoreBuy(Player player) {
        System.out.println("Buy an amount of chosen animals.\n");
        System.out.println("(1) " + chicken.getType() + "  $" + chicken.getCost() + " . Diet: " + chicken.getDiet());
        System.out.println("(2) " + cat.getType() + "  $" + cat.getCost() + " . Diet: " + cat.getDiet());
        System.out.println("(3) " + dog.getType() + "  $" + dog.getCost() + " . Diet: " + dog.getDiet());
        System.out.println("(4) " + cow.getType() + "  $" + cow.getCost() + " . Diet: " + cow.getDiet());
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
                    System.out.println("Invalid choice\n");
                    animalStoreBuy(player);
                }
            }
        } catch (NumberFormatException ne) {
            System.out.println("This is not a number");
        }
    }


    private void foodStoreBuy(Player player) {
        System.out.println("Buy an amount of chosen food.\n");
        System.out.println("(1) " + hay.getType() + "  $" + hay.getCost() + " per kg. Health boost: " + hay.getHealthBoost());
        System.out.println("(2) " + meat.getType() + "  $" + meat.getCost() + " per kg. Health boost: " + meat.getHealthBoost());
        System.out.println("(3) " + milk.getType() + "  $" + milk.getCost() + " per liter. Health boost: " + milk.getHealthBoost());
        System.out.println("(4) " + seed.getType() + "  $" + seed.getCost() + " per kg. Health boost: " + seed.getHealthBoost());
        System.out.println("(5) " + vegetables.getType() + "  $" + vegetables.getCost() + " per kg. Health boost: " + vegetables.getHealthBoost());
        String input = scanner.next();
        System.out.println("How much do you want to buy?");
        String amount = scanner.next();
        switch (parseInt(input)) {
            case 1 -> store.buyFood(player, hay, parseInt(amount));
            case 2 -> store.buyFood(player, meat, parseInt(amount));
            case 3 -> store.buyFood(player, milk, parseInt(amount));
            case 4 -> store.buyFood(player, seed, parseInt(amount));
            case 5 -> store.buyFood(player, vegetables, parseInt(amount));
            default -> {
                System.out.println("Invalid choice\n");
                foodStoreBuy(player);
            }
        }
    }


    private void feedAnimal(Player player) {
        Food foodInStack = null;
        Animal feedingAnimal = null;
        int foodStack;

        System.out.println("Which animals do you want to feed?.\n");
        System.out.println("(1) " + chicken.getType() + " . Diet: " + chicken.getDiet());
        System.out.println("(2) " + cat.getType() + " . Diet: " + cat.getDiet());
        System.out.println("(3) " + dog.getType() + " . Diet: " + dog.getDiet());
        System.out.println("(4) " + cow.getType() + " . Diet: " + cow.getDiet());
        System.out.print("Enter animal: ");
        String fedAnimal = scanner.next();
        System.out.println("(1) " + hay.getType() + " . Health boost: " + hay.getHealthBoost());
        System.out.println("(2) " + meat.getType() + " . Health boost: " + meat.getHealthBoost());
        System.out.println("(3) " + milk.getType() + " . Health boost: " + milk.getHealthBoost());
        System.out.println("(4) " + seed.getType() + " . Health boost: " + seed.getHealthBoost());
        System.out.println("(5) " + vegetables.getType() + " . Health boost: " + vegetables.getHealthBoost());
        System.out.println("Enter food type: ");
        String chosenFood = scanner.next();
        System.out.println("Enter amount of food: ");
        String foodAmount = scanner.next();

        try {
            switch (parseInt(chosenFood)) {
                case 1 -> foodInStack = hay;
                case 2 -> foodInStack = meat;
                case 3 -> foodInStack = milk;
                case 4 -> foodInStack = seed;
                case 5 -> foodInStack = vegetables;
                default -> foodInStack = none;

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

        foodStack = parseInt(foodAmount);

        if (foodStack > player.getPlayerFood(foodInStack)) {
            System.out.println("Not valid with no food.");
            feedAnimal(player);
        } else {
            CopyOnWriteArrayList<Animal> playersAnimals = player.getAnimalArray();
            while (foodStack > 0) {
                for (Animal individual : playersAnimals) {
                    assert feedingAnimal != null;
                    if (individual.getType().equals(feedingAnimal.getType())) {
                        String pickyEater = String.valueOf(individual.getDiet());

                        String currentServed = String.valueOf(foodInStack.getType());
                        if (pickyEater.contains(currentServed)) {
                            if (individual.getHealth() > 100) {
                                individual.setHealth(100);
                            } else {
                                int healingfromfood = foodInStack.getHealthBoost() * individual.getFoodBoost();
                                int individualhealth = individual.getHealth();
                                individual.setHealth((individualhealth + healingfromfood));
                                player.removePlayerFood(foodInStack);
                                foodStack = foodStack - 1;
                                System.out.println(individual.getName() + " the " + individual.getType() +
                                        " ate of " +  foodInStack.getType().toString().toLowerCase() +
                                        ", new health is " +  individual.getHealth());
                            }
                        } else {
                            System.out.println("Invalid choice.");
                            foodStack = 0;
                            feedAnimal(player);
                        }

                    }
                }
            }
        }
    }


    private void mateAnimal(Player player) {
        int males = 0;
        int females = 0;
        int pairs = 0;
        Animal animalMate = null;

        System.out.println("Which animals do you want to breed?.\n");
        System.out.println("(1) " + chicken.getType());
        System.out.println("(2) " + cat.getType());
        System.out.println("(3) " + dog.getType());
        System.out.println("(4) " + cow.getType());
        System.out.print("Enter animal: ");

        switch (parseInt(scanner.next())) {
            case 1 -> animalMate = chicken;
            case 2 -> animalMate = cat;
            case 3 -> animalMate = dog;
            case 4 -> animalMate = cow;
            default -> System.out.println("Not valid\n");
        }

        ArrayList<Animal> singletype = new ArrayList<>();
        for (Animal individual : player.getAnimalArray()) {

            if (individual.getType().equals(animalMate.getType())) {
                singletype.add(individual);
            }
        }
        for (Animal individual : singletype) {

            if (individual.getGender().equals(Animal.Gender.MALE)) {
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
                player.spawnAnimalfromBreeding(animalMate);
            } else {
                System.out.println("Not Valid");
            }
        }

    }

    public void animalStoreSell(Player player) {
        player.countAnimals();
        CopyOnWriteArrayList<Animal> playerInventory = player.getAnimalArray();
        String sold;

        System.out.println("Which animals do you want to sell?.\n");
        System.out.print("Enter animal(1,2,3...): ");
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
