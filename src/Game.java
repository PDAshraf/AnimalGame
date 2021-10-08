import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public Scanner myScan;
    public ArrayList<Player> player;
    public int menMatch;
    public Store store;
    public Menu menu;
    private int valPlayers,Rounds,menuChoice;

    public Game() {
        myScan = new Scanner(System.in);
        player = new ArrayList<>();
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
        System.out.println("How many players?(1-4)");
        amountPlayers();
        /**
         * Loop amount of players to init names and budget of each player
         */
        for (int i=0;i<valPlayers;i++){
            int j= i+1;
            System.out.println("Name of Player"+j+": ");
            String name = myScan.next();
            Player p = new Player(name,10000);
            player.add(p);
        }

        System.out.println("Lets go.."+Rounds+" Rounds!");
        for(int i=1; i<=Rounds;i++){

            for(int j=1;j<=valPlayers;j++){
                System.out.println("*".repeat(50));

                System.out.println("**Round "+i+"**Of*"+Rounds+"**");
                System.out.println("It's "+ player.get(j-1).getPlayerName()+"'s turn and you have "+player.get(j-1).budget+"$.");

                player.get(j-1).printAnimals();
                System.out.println(" ");
                player.get(j-1).printFood();
                System.out.println(" ");
                menu.printChoiceMenu();
                menuChoice();
                switch (menuChoice) {
                    case 1 -> {
                        System.out.println("**Buy Animals**");
                        store.buyAnimal(player.get(j - 1));
                    }
                    case 2 -> {
                        System.out.println("**Buy Food**");
                        store.buyFood(player.get(j - 1));

                    }
                    case 3 -> {
                        System.out.println("**Feed Animal**");
                        player.get(j - 1).feedAnimal();
                    }
                    case 4 -> {
                        System.out.println("**Mate Animals");
                        player.get(j - 1).mateAnimal();
                    }
                    case 5 -> {
                        System.out.println("**Sell Animal**");
                        store.sellAnimal(player.get(j - 1));
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
        Rounds = myScan.nextInt();
            while (Rounds < 5 || Rounds > 30) {
                System.out.println("Chose between 5-30 rounds");
                Rounds = myScan.nextInt();
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
