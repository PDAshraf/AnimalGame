package animalgame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the game class that...
 * @author Ashraf, Sharshar
 */
public class Game {

    public Scanner myScan;
    public ArrayList<Player> players;
    public int menMatch;
    public Store store;
    public Menu menu;
    private int valPlayers, rounds,menuChoice;

    /**
     * Game construector
     */
    public Game() {
        myScan = new Scanner(System.in);
        players = new ArrayList<>();
        store = new Store();
        menu = new Menu();


        System.out.println("Animal game. Let's Start!");

        /**
         * Amount of rounds chioce
         */
        System.out.println("Chose amount of rounds to play(5-30): ");
        amountRounds();

        /**
         * Amount of player choice
         */
        menu.printAskForPlayers();
        amountPlayers();
        /**
         * Loop amount of players to init names and budget of each player
         */
        for (int i=0;i<valPlayers;i++){
            int j= i+1;
            System.out.println("Name of Player "+j+": ");
            String name = myScan.next();
            Player p = new Player(name,10000);
            players.add(p);
        }

        System.out.println("Lets go.."+ rounds +" Rounds!");
        for(int i = 1; i<= rounds; i++){

            for(int j=1;j<=valPlayers;j++){
                System.out.println("*".repeat(50));

                System.out.println("**Round "+i+"**Of*"+ rounds +"**");
                System.out.println("It's "+ players.get(j-1).getPlayerName()+"'s turn and you have "+ players.get(j-1).budget+"$.");

                players.get(j-1).printAnimals();
                System.out.println(" ");
                players.get(j-1).printFood();
                System.out.println(" ");
                menu.printChoiceMenu();
                menuChoice();
                switch (menuChoice) {
                    case 1 -> {
                        System.out.println("**Buy Animals**");
                        store.buyAnimal(players.get(j - 1));
                    }
                    case 2 -> {
                        System.out.println("**Buy Food**");
                        store.buyFood(players.get(j - 1));

                    }
                    case 3 -> {
                        System.out.println("**Feed Animal**");
                        players.get(j - 1).feedAnimal();
                    }
                    case 4 -> {
                        System.out.println("**Mate Animals");
                        players.get(j - 1).mateAnimal();
                    }
                    case 5 -> {
                        System.out.println("**Sell Animal**");
                        store.sellAnimal(players.get(j - 1));
                    }
                    default -> {
                        System.out.println("Choose 1-5 ");
                        menuChoice();
                    }
                }
            }
        }
    }

    /**
     * Method to init Rounds
     */
    public void amountRounds() {
        rounds = myScan.nextInt();
            while (rounds < 5 || rounds > 30) {
                System.out.println("Chose between 5-30 rounds");
                rounds = myScan.nextInt();
            }
    }

    /**
     * Method to init amount of players
     */
    public void  amountPlayers() {
        valPlayers = myScan.nextInt();
        while (valPlayers < 1 || valPlayers > 4) {
            System.out.println("Chose 1-4 players");
            valPlayers = myScan.nextInt();
        }
    }

    public int menuChoice() {
        menuChoice = myScan.nextInt();
        while (menuChoice > 5 || menuChoice < 1) {
            System.out.println("Sorry, not valid. Choose 1, 2, 3, 4 or 5.");
            menuChoice = myScan.nextInt();
        }
        return menuChoice;
    }

}
