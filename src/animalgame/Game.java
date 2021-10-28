package animalgame;

import java.util.concurrent.CopyOnWriteArrayList;

/***
 * Game
 * Contains game setup, flow and major events
 *
 * @author Andreas Lindgren, Toriqul Islam Sohan
 */
public class Game {
    private final int startingCash;
    private final int playersPlaying;
    Menu menu = new Menu();

    public CopyOnWriteArrayList<Player> playerBox = new CopyOnWriteArrayList<>();

    /***
     * Game constructor
     *
     * Initiates variables, creates objects for various entities
     */
    public Game(){
        int gameTotalTurns = menu.SetupTurnMenu();
        playersPlaying = menu.SetupPlayerMenu();
        startingCash = 500;//menu.SetupCashMenu();
        spawnPlayers();

        int gameCurrentTurn = 1;
        while(gameCurrentTurn <= gameTotalTurns){
            for(Player player:playerBox){
                menu.PrintPlayerStatus(player, gameCurrentTurn);
                player.deadAnimalControl();
                menu.GameplayMenu(player);
                player.roundEndHealthDecrease();
                if (player.playerAnimals.isEmpty() && player.getPlayerCash() <= 0){
                    playerBox.remove(player);
                    System.out.println("\n ~~"+player.getPlayerName() + " IS OUT~~ ");
                }
            }

            gameCurrentTurn++;
        }
        for (Player player: playerBox){
            player.sellAllAnimal();
        }
        String winner = "";
        int highestScore = 0;
        System.out.println("GAME END!\nTotal scores:\n");
        for (Player player:playerBox){
            if (player.getPlayerCash() > highestScore){
                highestScore = player.getPlayerCash();
                winner = player.getPlayerName();
            }
            System.out.println(player.getPlayerName() + " collected $" +player.getPlayerCash());
        }
        System.out.println("The winner is " + winner);
    }

    /***
     * spawnPlayers
     *
     * Method that creates the individual player objects
     */
    public void spawnPlayers() {
        for(int playerSetupCounter = 0; playerSetupCounter <= (playersPlaying-1); playerSetupCounter++){
            this.playerBox.add(playerSetupCounter, new Player(startingCash, menu.SetupPlayerName(playerSetupCounter)));
        }
    }
}
