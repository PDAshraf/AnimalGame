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
            System.out.println("1.Cow(200$) 2.Cat(50$) 3.Dog(100$) 4.Chicken(20$)");
            int animChoice = animalChoice();
            System.out.println("Chose Gender\n 1.Male  2.Female");
            int gendChoice = genderChoice();
            System.out.println("Name your animal: ");
            String name = myScan.next();
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
            boolean playerSell = true;
            //show players animal list
            System.out.println("Here is your animal list:\n");
            while (playerSell) {
                for (int i = 0; i < player.animalList.size(); i++) {// visa animals
                    System.out.println(i + "." + player.animalList.get(i).name);
                }
                System.out.println("Please choose which Animal you'd like to sell.");
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
    }


    public void buyFood(Player player) {
        ArrayList<Food> foodChosen = new ArrayList<>();
        ArrayList<Integer> amountChosen = new ArrayList<>();
        boolean playerFood = true;
        while (playerFood) {
            System.out.println("Please choose the number for food you'd like to buy.");
            System.out.println("1.Vegetable(3kr/kg) 2.Meat(5kr/kg) 3.Milk(2kr/kg) 4.Seed(2kr/kg");
            int foodChoice = myScan.nextInt();
            int amount,i=1;
            switch (foodChoice) {
                case 1: //Vegetable
                    System.out.println("Amount of vegetables to buy: ");
                    amount=myScan.nextInt();
                    foodChosen.add(new Vegetables("Vegetables", 3));
                    amountChosen.add(amount);
                    break;
                case 2: //Meat
                    System.out.println("Amount of Meat to buy: ");
                    amount = myScan.nextInt();
                    foodChosen.add(new Meat("Meat", 5));
                    amountChosen.add(amount);
                    break;
                case 3://Milk
                    System.out.println("Amount of Milk to buy: ");
                    amount = myScan.nextInt();
                    foodChosen.add(new Milk("Milk", 2));
                    amountChosen.add(amount);
                    break;
                case 4:
                    System.out.println("Amount of Seed to buy: ");
                    amount = myScan.nextInt();
                    foodChosen.add(new Seed("Seed", 2));
                    amountChosen.add(amount);
                    break;
                default:
                    System.out.println("Invalid input,try again");
            }
            playerFood=false;
        }
    }

    public void createAnimal( int animaChoice, int genderChoice, ArrayList<Animal > animalChoice, String name){
        switch (animaChoice) {
            case 1://Cow
                if (genderChoice == 1) { //male
                    animalChoice.add(new Cow(name, "male"));
                } else if (genderChoice == 2) {
                    animalChoice.add(new Cow(name, "female"));
                } else {
                    System.out.println("Invalid input");
                }
                break;
            case 2://Cat
                if (genderChoice == 1) { //male
                    animalChoice.add(new Cat(name, "male"));
                } else if (genderChoice == 2) {
                    animalChoice.add(new Cat(name, "female"));
                } else {
                    System.out.println("Invalid input");
                }
                break;
            case 3://Dog
                if (genderChoice == 1) { //male
                    animalChoice.add(new Dog(name, "male"));
                } else if (genderChoice == 2) {
                    animalChoice.add(new Dog(name, "female"));
                } else {
                    System.out.println("Invalid input");
                }
                break;
            case 4: //Chicken
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


