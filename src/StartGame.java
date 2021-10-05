import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartGame {

    //Player player =new Player();

    public static void main(String[] args) {
        System.out.println("Hej");
        gameInit();
       // buyFood();
    }
    public static void gameInit(){
        int rounds=0;
        int Spelare=0;
        Player player = new Player();
        ArrayList<String> playerNameList = new ArrayList<>();
        Scanner myScan = new Scanner(System.in);

        System.out.println("Hur många rundor vill ni spel?(min 5 max 30");
        while (rounds<5 || rounds>30){
            System.out.println("ROUNDS !! Min 5 || Max 30 !! ROUNDS");
            rounds = myScan.nextInt();
        }
            System.out.println("Great! "+rounds+" Rounds to Play..");
        System.out.println("Antal Spelare: ");
        Spelare = myScan.nextInt();
        /**
         * Skapa spelar objekt efter antal spelare
         */
        for(int i=0;i<Spelare;i++) {
            int j=i+1;
            System.out.println("Namn Spelare"+j);
            playerNameList.add(myScan.nextLine());
        }
    }
    private static void buyFood(){
        Store vendor = new Store();
       // player.setPlayer();
        vendor.foodVendor();
    }

}
