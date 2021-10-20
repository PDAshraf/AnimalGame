package animalgame;

import animalgame.animals.abstractmodels.Animal;
import animalgame.food.abstractmodels.Food;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Player {
    public ArrayList<Animal> animalList;
    public ArrayList<Food> foodList;
    public Scanner myScan;
    public int budget;
    private String playerName;

    public Player(String playerName, int budget) {
        this.playerName = playerName;
        this.budget = budget;
        animalList = new ArrayList<>();
        foodList = new ArrayList<>();
        myScan = new Scanner(System.in);
    }

    public void printAnimals() {
        System.out.println("Your animals:");
        for (int i = 0; i < this.animalList.size(); i++) {
            System.out.println(this.animalList.get(i).name + ". Health: " + this.animalList.get(i).health);
        }
    }

    public void printFood() {
        System.out.println("Your stored food: ");
        for (int i = 0; i < this.foodList.size(); i++) {
            System.out.println(this.foodList.get(i).name + ".  Amount: " + this.foodList.get(i).amount);
        }
    }

    public void feedAnimal() {
        if (this.animalList.isEmpty() || this.foodList.isEmpty()) {
            System.out.println("Not valid option");
        } else {
            /**
             * Print animal to choose
             */
            printAnimals();
            System.out.println("Choose animal to feed: ");
            int indexC0 = myScan.nextInt();
            Animal animalChoice = animalList.get(indexC0);
            /**
             * Print food to choose.
             */
            printFood();
            System.out.println("Chose food: ");
            int indexC1 = myScan.nextInt();
            Food foodChoice = this.foodList.get(indexC1);

            System.out.println("You got" + foodChoice.amount + "kg of" + foodChoice.name);
            System.out.println("How much to feed: ");

            /**
             * Generate new values to list refering to amount choosen
             */
            int amountChoosen = myScan.nextInt();
            if (amountChoosen == foodChoice.amount) {
                this.foodList.remove(foodChoice);
            } else {
                foodChoice.amount = foodChoice.amount - amountChoosen;
            }
        }
    }

    public void mateAnimal() {
        if ((animalList.isEmpty()) || (animalList.size() == 1)) {
            System.out.println("No animal available");
        } else {
            printAnimals();

            /**
             * Fitst animal mate choice
             */
            System.out.println("Chose animalgame.animals.abstractmodels.Animal to mate with another: ");
            int c0 = myScan.nextInt();
            Animal mate0 = this.animalList.get(c0);

            /**
             * Second animal mate choice
             */
            System.out.println("Choose second animal to mate with another: ");
            int c1 = myScan.nextInt();
            Animal mate1 = this.animalList.get(c1);

            if ((mate0.getGender()==mate1.getGender())&& (mate0.getClass()== mate1.getClass())){
                System.out.println("Cant mate same gender");
            }else if(!(mate0.getClass()== mate1.getClass())){
                System.out.println("Cant mate with other species");
            }else{
                int Rand = (int) (Math.random() * 2)+1;
                switch (Rand) {
                    case 1:
                        System.out.println("Mate unsuccessful");
                        break;
                    case 2: // pairing succeeded
                        System.out.println("Name the newborn");
                        String babyName = myScan.next();
                        mate0.newBorn(mate1,this,babyName);
                        break;
                }
            }
        }
    }
    public String getPlayerName(){
        return playerName;
    }

    public void deliverAnimals(ArrayList<Animal> animalChoice) {
        animalList.addAll(animalChoice);
    }

    class GetResult implements Comparator<Player> {
        public int compare(Player o1, Player o2) {
            return o1.budget - o2.budget;
        }
    }
}
