 /*  
  * Họ và tên: Phan Thế Anh
  * MSSV: 20204941
 */
package controller;
import model.ComputerPlayer;
import model.Constant;
import model.Dice;
import model.Player;
import java.util.ArrayList;
import java.util.Random;

public class GameController {
    private ArrayList<Player> players;
    private ArrayList<Dice> dices;

    private int currentPlayerID;
    private int winnerID = -1;

    public GameController(ArrayList<Player> players, ArrayList<Dice> dices) {
        this.players = players;
        this.dices = dices;
        currentPlayerID = 0;
    }

    // Chỉ định người chơi tiếp theo
    private void nextPlayer() {
        currentPlayerID++;
        if (currentPlayerID >= players.size()) {
            currentPlayerID = 0;
        }
    }

    // Tiến hành xúc xắc, lưu điểm
    private void roll() {
        Player player = players.get(currentPlayerID);
        System.out.println("***************************");
        System.out.println("Nguoi choi: " + players.get(currentPlayerID).getName());
        // Lấy ngẫu nhiên xúc xắc
        Random random = new Random();
        int diceID = random.nextInt(Constant.MAX_DICE);
        Dice dice = dices.get(diceID);
        // tiến hành rool
        int score = dice.roll();

        System.out.println("Roll duoc: " + score);
        int playerScore = player.getPoint() + score;
        
        if(playerScore == Constant.MAX_SCORE) {
            winnerID = currentPlayerID;
            System.out.println("=============================");
            System.out.println("Nguoi choi: " +  players.get(currentPlayerID).getName());
            System.out.println("Roll duoc: " + score);
            System.out.println("21 diem");
            System.out.println("=============================");
        } else if(playerScore > Constant.MAX_SCORE) {
            player.setPoint(0);
        } else {
            player.setPoint(playerScore);
        }

        System.out.println("Diem: " + player.getPoint());

//        System.out.print("Nguoi choi: " + players.get(currentPlayerID).getName());
//        System.out.println(". Diem luc sau: " + players.get(currentPlayerID).getPoint());

    }

    public void endGame() {
        System.out.println("==============Ket qua===============");
        System.out.printf("Nguoi chien thang: %s\n", players.get(winnerID).getName());
        System.out.println("**********************************************");
        for(int i = 0; i < Constant.MAX_PLAYER; i++) {
            if(i == winnerID)
                continue;
            if(players.get(i) instanceof ComputerPlayer) {
                ComputerPlayer computerPlayer = (ComputerPlayer) players.get(i);
                System.out.printf("May %d: %s\n", i + 1,  computerPlayer.getEmotion());
            }
        }
    }

    // Chơi game
    public void play() {
        while (true) {
            if(winnerID >= 0) {
                endGame();
                break;
            }
            roll();
            nextPlayer();
        }
    }

}
