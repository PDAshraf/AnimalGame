package animalgame;

import java.util.concurrent.CopyOnWriteArrayList;

/***
 * contains "Game engine"
 *
 * @author Ashraf, Sharshar
 */
public class Game {
    private final int startingCash;
    private final int playersPlaying;
    Menu menu = new Menu();

    public CopyOnWriteArrayList<Player> playerBox = new CopyOnWriteArrayList<>();


    public Game(){
        int totalRounds = menu.initGame();
        playersPlaying = menu.SetupPlayerMenu();
        startingCash = 500;//menu.SetupCashMenu();
        getPlayer();

        int round = 1;
        while(round <= totalRounds){
            for(Player player:playerBox){
                menu.getPlayerStatus(player, round);
                player.deadAnimalControl();
                menu.gameMenu(player);
                player.healthDecrease();
                if (player.playerAnimals.isEmpty() && player.getPlayerBudget() <= 0){
                    playerBox.remove(player);
                    System.out.println("\n "+player.getPlayerName() + "s Turn ");
                }
            }

            round++;
        }
        for (Player player: playerBox){
            player.sellAll();
        }
        String winner = "";
        int highestScore = 0;
        System.out.println("GAME END!\nTotal scores:\n");
        for (Player player:playerBox){
            if (player.getPlayerBudget() > highestScore){
                highestScore = player.getPlayerBudget();
                winner = player.getPlayerName();
            }
            System.out.println(player.getPlayerName() + " collected $" +player.getPlayerBudget());
        }
        System.out.println("The winner is " + winner);
    }


    public void getPlayer() {
        for(int playerSetupCounter = 0; playerSetupCounter <= (playersPlaying-1); playerSetupCounter++){
            this.playerBox.add(playerSetupCounter, new Player(startingCash, menu.setPlayerName(playerSetupCounter)));
        }
    }
}
