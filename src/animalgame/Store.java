package animalgame;

import animalgame.animals.*;
import animalgame.animals.abstractmodels.Animal;
import animalgame.food.*;
import animalgame.food.abstractmodels.Food;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    public Scanner myScan;
    public Store() {
        myScan = new Scanner(System.in);

    }


    public void buyAnimal(Player player) {
        ArrayList<Animal> animalChoice = new ArrayList<>();
        boolean playerChoose = true;
        System.out.println("Chose a number to buy animal(1-5)");
        while (playerChoose) {
            int i=1;
            System.out.println("1.animalgame.animals.Cow(200$) 2.animalgame.animals.Cat(50$) 3.animalgame.animals.Dog(100$) 4.animalgame.animals.Chicken(20$)");
            int animaChoice = animalChoice();
            System.out.println("Chose Gender\n 1.Male  2.Female");
            int gendChoice = genderChoice();
            System.out.println("Name your animal: ");
            String name = myScan.next();
            createAnimal(animaChoice,gendChoice,animalChoice,name);
            player.deliverAnimals(animalChoice);
            playerChoose=false;
        }
    }

    public int animalChoice() {
        int animalChoice = myScan.nextInt();
        while (animalChoice < 1 || animalChoice > 4) {
            System.out.println("Choose between 1-4");
            animalChoice = myScan.nextInt();
        }
        return animalChoice;
    }



    public int genderChoice() {
        int genderChoice = myScan.nextInt();
        while (!(genderChoice == 1 || genderChoice == 2)) {
            System.out.println("Not valid, choose 1 or 2");
            genderChoice = myScan.nextInt();
        }
        return genderChoice;
    }


    public void sellAnimal(Player player) {
        if (player.animalList.isEmpty()) {
            System.out.println("No animal in your list!");
        } else {

            //show players animal list
            System.out.println("Here is your animal list:\n");
                for (int i = 0; i < player.animalList.size(); i++) {// visa animals
                    System.out.println(i + "." + player.animalList.get(i).name);
                }
                System.out.println("Please choose which animalgame.animals.abstractmodels.Animal you'd like to sell.");
                int indexChosen = myScan.nextInt();//player choose index for animal to sel;
                Animal animalToSell = player.animalList.get(indexChosen);//get animal from the list

                int currentHealth = animalToSell.health;
                int priceToSell = 0;
                priceToSell = animalToSell.price;
                System.out.println(animalToSell.name + "is sold for " + priceToSell);
                player.animalList.remove(animalToSell);
                player.budget = player.budget + priceToSell;


        }
    }


    public void buyFood(Player player) {
        ArrayList<Food> foodChosen = new ArrayList<>();
        ArrayList<Integer> amountChosen = new ArrayList<>();
        boolean playerFood = true;
        while (playerFood) {
            System.out.println("Please choose the number for food you'd like to buy.");
            System.out.println("1.Vegetable(3kr/kg) 2.animalgame.food.Meat(5kr/kg) 3.animalgame.food.Milk(2kr/kg) 4.animalgame.food.Seed(2kr/kg");
            int foodChoice = myScan.nextInt();
            int amount,i=1;
            switch (foodChoice) {
                case 1: //Vegetable
                    System.out.println("Amount of vegetables to buy: ");
                    amount=myScan.nextInt();
                    foodChosen.add(new Vegetables("animalgame.food.Vegetables", 3));
                    amountChosen.add(amount);
                    break;
                case 2: //animalgame.food.Meat
                    System.out.println("Amount of animalgame.food.Meat to buy: ");
                    amount = myScan.nextInt();
                    foodChosen.add(new Meat("animalgame.food.Meat", 5));
                    amountChosen.add(amount);
                    break;
                case 3://animalgame.food.Milk
                    System.out.println("Amount of animalgame.food.Milk to buy: ");
                    amount = myScan.nextInt();
                    foodChosen.add(new Milk("animalgame.food.Milk", 2));
                    amountChosen.add(amount);
                    break;
                case 4:
                    System.out.println("Amount of animalgame.food.Seed to buy: ");
                    amount = myScan.nextInt();
                    foodChosen.add(new Seed("animalgame.food.Seed", 2));
                    amountChosen.add(amount);
                    break;
                default:
                    System.out.println("Invalid input,try again");
            }
            playerFood=false;
        }
    }

    public void createAnimal(int animaChoice, int genderChoice, ArrayList<Animal> animalChoice, String name){
        switch (animaChoice) {
            case 1://animalgame.animals.Cow
                if (genderChoice == 1) { //male
                    animalChoice.add(new Cow(name, "male"));
                } else if (genderChoice == 2) {
                    animalChoice.add(new Cow(name, "female"));
                } else {
                    System.out.println("Invalid input");
                }
                break;
            case 2://animalgame.animals.Cat
                if (genderChoice == 1) { //male
                    animalChoice.add(new Cat(name, "male"));
                } else if (genderChoice == 2) {
                    animalChoice.add(new Cat(name, "female"));
                } else {
                    System.out.println("Invalid input");
                }
                break;
            case 3://animalgame.animals.Dog
                if (genderChoice == 1) { //male
                    animalChoice.add(new Dog(name, "male"));
                } else if (genderChoice == 2) {
                    animalChoice.add(new Dog(name, "female"));
                } else {
                    System.out.println("Invalid input");
                }
                break;
            case 4: //animalgame.animals.Chicken
                if (genderChoice == 1) { //male
                    animalChoice.add(new Chicken(name, "male"));
                } else if (genderChoice == 2) {
                    animalChoice.add(new Chicken(name, "female"));
                } else {
                    System.out.println("Invalid input");
                }
                break;
            default:
                System.out.println("Invalid input!");
        }
    }
}


